package avaliacaoDocente.Disciplina.DAO;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Professor.Model.Professor;

@Repository
@SuppressWarnings("unchecked")
public class Disc_ProfDAOImp implements Disc_ProfDAO{

	@Autowired
	private SessionFactory session;
	
	@Override
	public void cadastraDiscPro(Disciplina_Professor disc_pro) {
		session.getCurrentSession().save(disc_pro);
	}

	@Override
	public void editarDiscPro(Disciplina_Professor disc_pro) {
		session.getCurrentSession().merge(disc_pro);
	}

	@Override
	public void removerDiscPro(long id_disc_pro) {
		session.getCurrentSession().delete(buscarDiscPro(id_disc_pro));
	}
	

	@Override
	public List<Disciplina_Professor> listarDiscPro() {
		return session.getCurrentSession().createCriteria(Disciplina_Professor.class).list();
	}

	@Override
	public Disciplina_Professor buscarDiscPro(long id_disc_pro) {
		return (Disciplina_Professor) session.getCurrentSession().createCriteria(Disciplina_Professor.class).add(Restrictions.eq("id_disc_pro", id_disc_pro)).uniqueResult();
	}

	@Override
	public List<Disciplina_Professor> disc_proProfessor(Long idProfessor) {
		List<Disciplina_Professor> lista = session.getCurrentSession().createCriteria(Disciplina_Professor.class).add(Restrictions.eq("professor.id_professor", idProfessor)).list();
		return lista;
	}

	@Override
	public List<Disciplina_Professor> disc_proDisciplina(Long idDisciplina) {
		List<Disciplina_Professor> lista = session.getCurrentSession().createCriteria(Disciplina_Professor.class).add(Restrictions.eq("disciplina.id_disciplina", idDisciplina)).list();
		return lista;
	}

	@Override
	public void removeDiscPro(Long id_disc, Long id_prof) {
		Disciplina_Professor disc_prof = (Disciplina_Professor) session.getCurrentSession().createCriteria(Disciplina_Professor.class).add(Restrictions.eq("disciplina.id_disciplina", id_disc)).add(Restrictions.eq("professor.id_professor", id_prof)).uniqueResult();
		session.getCurrentSession().delete(disc_prof);
	}
}
