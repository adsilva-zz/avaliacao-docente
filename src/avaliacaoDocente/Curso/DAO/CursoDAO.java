package avaliacaoDocente.Curso.DAO;

import java.util.List;

import avaliacaoDocente.Curso.Model.Curso;

public interface CursoDAO {

	public void cadastrarCurso(Curso curso);
	
	public void editarCurso(Curso curso);
	
	public void removerCurso(long id_cursoo);

	public List<Curso> listarCursos();

	public Curso buscarCurso(long id_curso);
	
}
