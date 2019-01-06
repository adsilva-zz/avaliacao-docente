package avaliacaoDocente.Disciplina.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import avaliacaoDocente.Curso.Model.Curso;

@Entity
public class Disciplina {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_disciplina;
	
	@Column(nullable = false)
	@NotEmpty(message = "{NotEmpty.Disciplina.nome_disciplina}")
	private String nome_disciplina;

	@Column(nullable = false)
	@NotEmpty(message = "{NotEmpty.Disciplina.periodo_disciplina}")
	private String periodo_disciplina;

	@ManyToOne
	private Curso cursos;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Disciplina_Professor> disc_prof;

	@Transient
	private boolean contem;
	
	public boolean isContem() {
		return contem;
	}

	public void setContem(boolean contem) {
		this.contem = contem;
	}

	public long getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(long id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}
	
	public String getPeriodo_disciplina() {
		return periodo_disciplina;
	}

	public void setPeriodo_disciplina(String periodo_disciplina) {
		this.periodo_disciplina = periodo_disciplina;
	}

	public Curso getCursos() {
		return cursos;
	}

	public void setCursos(Curso cursos) {
		this.cursos = cursos;
	}

	public List<Disciplina_Professor> getDisc_prof() {
		return disc_prof;
	}

	public void setDisc_prof(List<Disciplina_Professor> disc_prof) {
		this.disc_prof = disc_prof;
	}
	
	@Override
	public boolean equals(Object arg0) {
		
		return id_disciplina==(((Disciplina) arg0).getId_disciplina());
	}

}
