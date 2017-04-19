package chat.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import chat.entities.Usuario;
import chat.rn.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	private String destinoSalvar;
	private List<Usuario> lista;
	
	
	public String salvar(){
		FacesContext contex = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmaSenha)) {
			FacesMessage facemessage = new FacesMessage("A senha não foi confirmada corretamente");
			contex.addMessage(null, facemessage);
			return null;
		}
		this.usuario.setAtivo(true);
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		this.usuario = new Usuario();
		this.confirmaSenha=null;
		return "usuarioSucesso";
		
	}
	
	public String editar(){
		this.confirmaSenha = this.usuario.getSenha();
		return "/restrito/principal";
	}

	
/*	public String atribuiPermissao(Usuario usuario, String permissao){
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		}else {
			permissoes.add(permissao);
		}
		return null;
	}	*/
	
	
	
	public String ativar(){
		if (this.usuario.getAtivo()) 
			this.usuario.setAtivo(false);
		else 
			this.usuario.setAtivo(true);
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.salvar(this.usuario);
			return null;
	}

	
	public String excluir(){
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}	
	
	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}	
	

	public void redirect() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext().redirect("monitoria.jsf");
	}

}
