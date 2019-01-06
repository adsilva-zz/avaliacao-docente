package avaliacaoDocente.Disciplina.DAO;

import java.util.List;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Disciplina.Model.Disciplina;

public interface DisciplinaDAO {

	public void cadastraDisciplina(Disciplina disciplina);

	public void editarDisciplina(Disciplina disciplina);

	public void removerDisciplina(long id_disciplina);

	public List<Disciplina> listarDisciplinas();

	public Disciplina buscarDisciplina(long id_disciplina);
	
	public List<Disciplina> disciplinaCurso(long id_curso);
	
	public List<Disciplina> existeDisciplinas(String nome_disciplina, String periodo_disciplina);
	
}
