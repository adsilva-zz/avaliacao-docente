package avaliacaoDocente.Professor.DAO;

import java.util.List;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Professor.Model.Professor;

public interface ProfessorDAO {
	
	public void cadastrarProfessor(Professor professor);

	public void editarProfessor(Professor professor);
	
	public void removerProfessor(long id_professor);
	
	public List<Professor> listarProfessores();
	
	public Professor buscarProfessor(long id_professor);
	
	public List<Professor> existeProfessor(String nome_professor);

	public List<Professor> professorCurso(long id_curso);

}
