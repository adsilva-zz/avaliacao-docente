package avaliacaoDocente.Usuario.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Logar {
	
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "{NotEmpty.Logar.login_usuario}")
	private String login_usuario;

	@Column(nullable = false)
	@NotEmpty(message = "{NotEmpty.Logar.senha_usuario}")
	private String senha_usuario;;

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login) {
		this.login_usuario = login;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha) {
		this.senha_usuario = senha;
	}

}
