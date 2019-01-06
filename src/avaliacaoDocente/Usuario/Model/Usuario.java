package avaliacaoDocente.Usuario.Model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Usuario.DAO.UsuarioDAO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private long id_usuario;

	@Column(nullable = false)
	@NotEmpty(message = "{NotEmpty.Usuario.nome_usuario}")
	private String nome_usuario;

	@NotEmpty(message = "{NotEmpty.Usuario.data_ini}")
	private String data_ini;

	@NotEmpty(message = "{NotEmpty.Usuario.tipo_usuario}")
	private String tipo_usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso")
	@Valid
	private Curso curso;
	
	@Embedded
	@Valid
	private Logar logar;

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}


	public String getData_ini() {
		return data_ini;
	}

	public void setData_ini(String data_ini) {
		this.data_ini = data_ini;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Logar getLogar() {
		return logar;
	}

	public void setLogar(Logar logar) {
		this.logar = logar;
	}
	
}
