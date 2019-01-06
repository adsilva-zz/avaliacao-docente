package avaliacaoDocente.Curso.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Professor.Model.Professor;
import avaliacaoDocente.Usuario.Model.Usuario;
@Entity
public class Curso {

	@Id
	@Column(nullable = false)
	@NotNull(message = "{NotNull.Curso.id_curso}")
	private Long id_curso;
	
	@NotEmpty(message = "{NotEmpty.Curso.nome_curso}")
	private String nome_curso;
	
	@OneToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Professor> professores;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Usuario> usuarios;

	public Long getId_curso() {
		return id_curso;
	}

	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addDisciplinaCurso(Disciplina disciplina){
		this.disciplinas.add(disciplina);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
