package avaliacaoDocente.Disciplina.DAO;

import java.util.List;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Professor.Model.Professor;

public interface Disc_ProfDAO {

	public void cadastraDiscPro(Disciplina_Professor disc_pro);

	public void editarDiscPro(Disciplina_Professor disc_pro);

	public void removerDiscPro(long id_disc_pro);

	public List<Disciplina_Professor> listarDiscPro();

	public Disciplina_Professor buscarDiscPro(long id_disc_pro);
	
	public List<Disciplina_Professor> disc_proProfessor(Long idProfessor);
	
	public List<Disciplina_Professor> disc_proDisciplina(Long idDisciplina);
	
	public void removeDiscPro(Long id_disc, Long id_prof);

}
