package avaliacaoDocente.Professor.DAO;

import java.text.Normalizer;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Professor.Model.Professor;
import avaliacaoDocente.Utilitarios.DAO.UltilitariosDAO;

@Repository
public class ProfessorDAOImp implements ProfessorDAO{
	@Autowired
	private SessionFactory session;
	
	@Autowired
	private UltilitariosDAO servico_util;
	
	@Override
	public void cadastrarProfessor(Professor professor) {
		session.getCurrentSession().save(professor);
	}

	@Override
	public void editarProfessor(Professor professor) {
		session.getCurrentSession().update(professor);		
	}

	@Override
	public void removerProfessor(long id_professor) {
		session.getCurrentSession().delete(buscarProfessor(id_professor));
	}

	@Override
	public List<Professor> listarProfessores() {
		return session.getCurrentSession().createCriteria(Professor.class).list();
	}

	@Override
	public Professor buscarProfessor(long id_professor) {
		return (Professor)session.getCurrentSession().get(Professor.class, id_professor);
	}

	@Override
	public List<Professor> existeProfessor(String nome_professor) {
		nome_professor = servico_util.conversao(nome_professor);
		
		List<Professor> lista = session.getCurrentSession().createCriteria(Professor.class).add(Restrictions.like("nome_professor", nome_professor, MatchMode.EXACT)).list();
		
		return lista;
	}

	@Override
	public List<Professor> professorCurso(long id_curso){
		List<Professor> lista = session.getCurrentSession().createCriteria(Professor.class).add(Restrictions.eq("cursos.id_curso", id_curso)).addOrder(Order.asc("nome_professor")).list();
		return lista;
	}

}
