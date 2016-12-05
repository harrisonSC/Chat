package chat.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.supportcomm.dialout.util.Dialout;
import chat.entities.Personalidade;

@ManagedBean(name = "personalidadeBean")
@RequestScoped
public class PersonalidadeBean {
	private Personalidade personalidade = new Personalidade();

	public Personalidade getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(Personalidade personalidade) {
		this.personalidade = personalidade;
	}

	public String entrar(){
		
		try {
			List<Dialout> dialouts = new ArrayList<Dialout>();
			Dialout dialout = new Dialout();
			List<String> variable = new ArrayList<String>();
			
			 
			variable.add( "CALLERID(DNID)=8486" );
    		variable.add("destinationNumber=".concat(this.personalidade.getMsisdnPersonalidade()));
			
			dialout.setChannel("SIP/" + this.personalidade.getMsisdnPersonalidade());
			dialout.setExten("8486");
			dialout.setIpConnection("192.168.3.108");
			dialout.setLoginAsterisk("manager");
			dialout.setPassAsterisk("senha");
			dialout.setMsisdnOriginator("8486");
			dialout.setPriority(1);
			dialout.setVariables(variable );
			dialout.setContext("default");
			dialout.run();
			
			
			Thread threadDoPdf = new Thread(dialout);
        	threadDoPdf.start();
        	dialouts.add(dialout);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}

	
	 private class Channel{
		 private String msisdn;
		 private String msisdnOriginator;
		public String getMsisdn() {
			return msisdn;
		}
		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}
		public String getMsisdnOriginator() {
			return msisdnOriginator;
		}
		public void setMsisdnOriginator(String msisdnOriginator) {
			this.msisdnOriginator = msisdnOriginator;
		}
			
	 }
	
	
	
}
