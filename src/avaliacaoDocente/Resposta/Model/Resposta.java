package avaliacaoDocente.Resposta.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Pergunta.Model.Pergunta;
import avaliacaoDocente.Pergunta.Model.Pergunta_Disciplina;
import avaliacaoDocente.Usuario.Model.Usuario;

@Entity
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id_resposta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(nullable = false)
	private String resposta;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_disc_pro")
	private Disciplina_Professor disc_pro;

	public long getId_resposta() {
		return id_resposta;
	}

	public void setId_resposta(long id_resposta) {
		this.id_resposta = id_resposta;
	}
	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
