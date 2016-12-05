package chat.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
		
		return null;
		
	}

}
