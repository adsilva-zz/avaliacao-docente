package avaliacaoDocente.Disciplina.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Utilitarios.DAO.UltilitariosDAO;

@Repository
@SuppressWarnings("unchecked")
public class DisciplinaDAOImp implements DisciplinaDAO{
	@Autowired
	private SessionFactory session;
	
	@Autowired
	private UltilitariosDAO servico_util;
	
	@Override
	public void cadastraDisciplina(Disciplina disciplina) {
		session.getCurrentSession().save(disciplina);
	}

	@Override
	public void editarDisciplina(Disciplina disciplina) {
		session.getCurrentSession().merge(disciplina);
	}

	@Override
	public void removerDisciplina(long id_disciplina) {
		session.getCurrentSession().delete(buscarDisciplina(id_disciplina));
	}

	@Override
	public List<Disciplina> listarDisciplinas() {
		return session.getCurrentSession().createCriteria(Disciplina.class).list();
	}

	@Override
	public Disciplina buscarDisciplina(long id_disciplina) {
		return (Disciplina) session.getCurrentSession().get(Disciplina.class, id_disciplina);
	}

	@Override
	public List<Disciplina> disciplinaCurso(long id_curso) {
		List<Disciplina> lista = session.getCurrentSession().createCriteria(Disciplina.class).add(Restrictions.eq("cursos.id_curso", id_curso)).addOrder(Order.asc("nome_disciplina")).list();
		return lista;
	}

	@Override
	public List<Disciplina> existeDisciplinas(String nome_disciplina, String periodo_disciplina) {
		nome_disciplina = servico_util.conversao(nome_disciplina);
				List<Disciplina> lista = session.getCurrentSession().createCriteria(Disciplina.class).add(Restrictions.like("nome_disciplina", nome_disciplina, MatchMode.EXACT)).add(Restrictions.like("periodo_disciplina", periodo_disciplina, MatchMode.EXACT)).list();
		
		return lista;
	}
}
