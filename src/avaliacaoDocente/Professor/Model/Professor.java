package avaliacaoDocente.Professor.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.annotations.Transform;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id_professor;
	
	@Column(nullable = false, unique = true)
	@NotEmpty(message = "{NotEmpty.Professor.nome_professor}")
	private String nome_professor;
	
	@ManyToOne
	private Curso cursos;
	
	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Disciplina_Professor> disc_prof;
	
	public long getId_professor() {
		return id_professor;
	}

	public void setId_professor(long id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome_professor() {
		return nome_professor;
	}

	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}

	public List<Disciplina_Professor> getDisc_prof() {
		return disc_prof;
	}

	public void setDisc_prof(List<Disciplina_Professor> disc_prof) {	
		this.disc_prof = disc_prof;
	}

	public Curso getCursos() {
		return cursos;
	}

	public void setCursos(Curso cursos) {
		this.cursos = cursos;
	}	
}
