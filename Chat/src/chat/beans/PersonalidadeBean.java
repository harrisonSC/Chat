package chat.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import chat.entities.Personalidade;
import chat.util.Ligacao;

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
			
			Ligacao ligacao = new Ligacao();
			
			
			
			
			List<String> variables = new ArrayList<String>();
			
			variables.add("conferencia=entrar"); 
			
			
			ligacao.chamar(this.personalidade.getMsisdnPersonalidade(), "8486", "192.168.3.108", 5038,"manager","senha",variables);
			FacesContext contex = FacesContext.getCurrentInstance();
			FacesMessage facemessage = new FacesMessage("Ligação sendo efetuada, aguarde alguns segundos!");
			contex.addMessage(null, facemessage);
			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(personalidade);
			
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
