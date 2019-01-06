package avaliacaoDocente.Pergunta.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;

@Entity
public class Pergunta_Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id_per_disc;

	@ManyToOne
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;

	@ManyToOne
	@JoinColumn(name = "id_disc_pro")
	private Disciplina_Professor disc_pro;

	public long getId_per_disc() {
		return id_per_disc;
	}

	public void setId_per_disc(long id_per_disc) {
		this.id_per_disc = id_per_disc;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Disciplina_Professor getDisc_pro() {
		return disc_pro;
	}

	public void setDisc_pro(Disciplina_Professor disc_pro) {
		this.disc_pro = disc_pro;
	}

	
}
