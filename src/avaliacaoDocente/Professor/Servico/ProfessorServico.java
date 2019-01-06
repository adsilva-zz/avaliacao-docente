package avaliacaoDocente.Professor.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Professor.DAO.ProfessorDAO;
import avaliacaoDocente.Professor.Model.Professor;

@Service
@Transactional
public class ProfessorServico {

	@Autowired
	private ProfessorDAO servico_professor;
	
	public void cadastrarProfessor(Professor professor) {
		servico_professor.cadastrarProfessor(professor);
	}

	public void editarProfessor(Professor professor) {
		servico_professor.editarProfessor(professor);	
	}

	public void removerProfessor(long id_professor) {
		servico_professor.removerProfessor(id_professor);
	}

	public List<Professor> listarProfessores() {
		return servico_professor.listarProfessores();
	}

	public Professor buscarProfessor(long id_professor) {
		return servico_professor.buscarProfessor(id_professor);
	}
	
	public List<Professor> existiProfessor(String nome_professor){
		return servico_professor.existeProfessor(nome_professor);
	}
	
	public List<Professor> professorCurso(long id_curso){
		return servico_professor.professorCurso(id_curso);
	}

}
