package br.com.kentec.endpoint.controller;

import java.net.SocketException;
import java.util.Optional;
import java.io.*;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import br.com.kentec.endpoint.domain.Usuario;
import br.com.kentec.endpoint.service.UsuarioService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping()
	public String get() throws SocketException, IOException {
		
		String servidor = "araguaiasistemas.com.br";
        int porta = 21;
        String usuario = "araguaiasistemas";
        String senha = "ara@bra#618";
        
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(servidor, porta);
        ftpClient.login(usuario, senha);
        System.out.println("Deu certo");
        ftpClient.changeWorkingDirectory("/www/liberacao");
        
          String[] arq = ftpClient.listNames();

            System.out.println ("Listando arquivos: \n");

            for (String f : arq){
                System.out.println(f);            
            }
        
        InputStream iStream = ftpClient.retrieveFileStream("32005629000110.TXT");
        BufferedInputStream bInf = new BufferedInputStream(iStream);
        
        int bytesRead;
        byte[] buffer = new byte[1024]; 
        String fileContent = null; 
        
        /*System.out.println("读取文件 时出错,请确认文件 存在且配置的用户有权限读取");
        System.out.println("厨房的横梁上挂着一串洋葱。");
        System.out.println("你扯动细绳，木偶的手脚就会动。");
        System.out.println("अक्तूबर, अक्‍टूबर\" \"कौम, क़ौम");
        System.out.println("");*/
        
        String cnpj = null;
        String data = null;
        
        while((bytesRead = bInf.read(buffer))!= -1){
            fileContent = new String(buffer,0,bytesRead); 
            
            System.out.println("Leitura->: " + fileContent);
            cnpj = fileContent.substring(0, 14);
            data = fileContent.substring(14, 24);
            
            System.out.println(cnpj); 
            System.out.println(data);
        }
        
        iStream.close();
        ftpClient.quit();
        ftpClient.disconnect();
	
		return "API Teste EndPoint";
	}
	
	
	@GetMapping("/teste")
	public String novoTeste() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://www.araguaiasistemas.com.br/liberacao/41963733000109.TXT")
				.build();
		
		try(Response response = client.newCall(request).execute()){
			String linhaArquivo = response.body().string();
			
			String cnpj = linhaArquivo.substring(0, 14);
			String data = linhaArquivo.substring(14,24);
			System.out.println();
			return  cnpj+"-"+data;
		}				
	}
	
	
	@GetMapping("/xml")
	public void gerarXML() throws IOException {
		Optional<Usuario> user = us.findById(1L);
		BufferedWriter saida = new BufferedWriter(new FileWriter("C:\\teste\\teste.xml"));
		System.out.println(user.get().getFoto().toString());
		byte[] msgBytes = user.get().getFoto(); // retorna byte
		String msgDecode = new String(msgBytes); // tentando converter byte em String
		System.out.println("Mensagem descriptografada [" + msgDecode + "]");
		saida.write(msgDecode);
		 saida.close();
	}
	
	@GetMapping("/calculo")
	public String acharPercentualReduzido() {
		Float aliquotaNormal = 0.17F; // 17% = 17/100 = 0,17
		Float baseCheia = 372000F;
		Float baseReduzida = 153176.58F;
		Float baseDeReducao = baseReduzida*100/baseCheia;
		System.out.println(baseDeReducao);
		Float fatorAliquitoCheia = 100/aliquotaNormal; 
		System.out.println(fatorAliquitoCheia);
		Float aliquotaReduzida = baseDeReducao/fatorAliquitoCheia;
		System.out.println(aliquotaReduzida*100);
		return null;
	} 
	
}
