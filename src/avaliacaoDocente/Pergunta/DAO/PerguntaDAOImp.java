package avaliacaoDocente.Pergunta.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Pergunta.Model.Pergunta;
import avaliacaoDocente.Usuario.Model.Usuario;

@Repository
public class PerguntaDAOImp implements PerguntaDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void cadastraPergunta(Pergunta pergunta) {
		session.getCurrentSession().save(pergunta);
	}

	@Override
	public void editarPergunta(Pergunta pergunta) {
		session.getCurrentSession().merge(pergunta);		
	}

	@Override
	public void removerPergunta(long id_pergunta) {
		session.getCurrentSession().delete(buscarPergunta(id_pergunta));
	}

	@Override
	public List<Pergunta> listarPerguntas() {
		return session.getCurrentSession().createCriteria(Pergunta.class).list();
	}

	@Override
	public Pergunta buscarPergunta(long id_pergunta) {
		return (Pergunta)session.getCurrentSession().createCriteria(Pergunta.class).add(Restrictions.eq("id_pergunta", id_pergunta)).uniqueResult();
	}

}
