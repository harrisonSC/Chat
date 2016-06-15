package chat.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private Boolean ativo;
	private String login;
	private String nome;
	private String senha;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name="usuario_permissao",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})},
	joinColumns = @JoinColumn(name ="usuario"))
	@Column(name = "permissao", length=50)
	private Set<String>	permissao = new HashSet<String>();

	
	public Usuario() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}








}