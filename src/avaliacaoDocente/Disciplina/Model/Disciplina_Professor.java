package avaliacaoDocente.Disciplina.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import avaliacaoDocente.Professor.Model.Professor;

@Entity
public class Disciplina_Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id_disc_pro;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	public long getId_disc_pro() {
		return id_disc_pro;
	}

	public void setId_disc_pro(long id_disc_pro) {
		this.id_disc_pro = id_disc_pro;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
		
}
