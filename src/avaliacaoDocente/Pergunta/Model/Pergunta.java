	package avaliacaoDocente.Pergunta.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pergunta {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pergunta;

	@Lob
	@Column(nullable = false)
	@NotEmpty(message = "{NotEmpty.Pergunta.pergunta}")
	private String pergunta;

	public long getId_pergunta() {
		return id_pergunta;
	}

	public void setId_pergunta(long id_pergunta) {
		this.id_pergunta = id_pergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

}
