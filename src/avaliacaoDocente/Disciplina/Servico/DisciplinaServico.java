package avaliacaoDocente.Disciplina.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Disciplina.DAO.DisciplinaDAO;
import avaliacaoDocente.Disciplina.Model.Disciplina;

@Service
@Transactional
public class DisciplinaServico {
	
	@Autowired
	private DisciplinaDAO servico_disciplina;
	
	public void cadastraDisciplina(Disciplina disciplina) {
		servico_disciplina.cadastraDisciplina(disciplina);
	}

	public void editarDisciplina(Disciplina disciplina) {
		servico_disciplina.editarDisciplina(disciplina);
	}

	public void removerDisciplina(long id_disciplina) {
		servico_disciplina.removerDisciplina(id_disciplina);
	}

	public List<Disciplina> listarDisciplinas() {
		return servico_disciplina.listarDisciplinas();
	}

	public Disciplina buscarDisciplina(long id_disciplina) {
		return servico_disciplina.buscarDisciplina(id_disciplina);
	}

	public List<Disciplina> disciplinaCurso(long id_curso) {
		return servico_disciplina.disciplinaCurso(id_curso);
	}

	public List<Disciplina> existeDisciplina(String nome_disciplina, String periodo_disciplina){
		return servico_disciplina.existeDisciplinas(nome_disciplina, periodo_disciplina);
	}
}
