package avaliacaoDocente.Disciplina.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Disciplina.DAO.Disc_ProfDAO;
import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Professor.Model.Professor;

@Service
@Transactional
public class Disc_ProfServico {

	@Autowired
	private Disc_ProfDAO servi_disc_prof;
	
	public void cadastraDiscPro(Disciplina_Professor disc_pro){
		servi_disc_prof.cadastraDiscPro(disc_pro);
	}

	public void editarDiscPro(Disciplina_Professor disc_pro){
		servi_disc_prof.editarDiscPro(disc_pro);
	}

	public void removerDiscPro(long id_disc_pro){
		servi_disc_prof.removerDiscPro(id_disc_pro);
	}

	public List<Disciplina_Professor> listarDiscPro(){
		return servi_disc_prof.listarDiscPro();
	}

	public Disciplina_Professor buscarDiscPro(long id_disc_pro){
		return servi_disc_prof.buscarDiscPro(id_disc_pro);
	}
	
	public List<Disciplina_Professor> disc_proProfessor(Long idProfessor){
		return servi_disc_prof.disc_proProfessor(idProfessor);
	}
	
	public List<Disciplina_Professor> disc_proDisciplina(Long idDisciplina){
		return servi_disc_prof.disc_proDisciplina(idDisciplina);
	}

	public void removeDiscPro(Long id_disc, Long id_prof){
		servi_disc_prof.removeDiscPro(id_disc, id_prof);
	}
}
