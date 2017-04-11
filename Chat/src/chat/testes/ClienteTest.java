package chat.testes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import com.google.gson.Gson;

public class ClienteTest {

	
	@Test
	public void testaQueAConexaoComServidorFunciona() {
        String username = "asterisk";
        String password = "asterisk";
 
        String usernameAndPassword = username + ":" + password;
        String authorizationHeaderName = "Authorization";
        String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );


		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://192.168.3.108:8088");
		
		
		String conteudo = target.path("/ari/channels").request()
				         .header( authorizationHeaderName, authorizationHeaderValue ).get(String.class);
		System.out.println(conteudo);
		//new Gson().fromJson(conteudo, classOfT);
	}
}

