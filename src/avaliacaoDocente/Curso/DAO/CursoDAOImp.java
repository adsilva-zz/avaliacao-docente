package avaliacaoDocente.Curso.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Curso.Model.Curso;

@Repository
public class CursoDAOImp implements CursoDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void cadastrarCurso(Curso curso) {
		session.getCurrentSession().save(curso);
	}

	@Override
	public void editarCurso(Curso curso) {
		session.getCurrentSession().merge(curso);
	}

	@Override
	public void removerCurso(long id_curso) {
		session.getCurrentSession().delete(buscarCurso(id_curso));
	}

	@Override
	public List<Curso> listarCursos() {
		return session.getCurrentSession().createCriteria(Curso.class).addOrder(Order.asc("nome_curso")).list();
	}

	@Override
	public Curso buscarCurso(long id_curso) {
		return (Curso) session.getCurrentSession().createCriteria(Curso.class).add(Restrictions.eq("id_curso", id_curso)).uniqueResult();
	}
	
}
