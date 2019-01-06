package avaliacaoDocente.Resposta.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Resposta.Model.Resposta;
@Repository
public class RespostaDAOImp implements RespostaDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void salvarResposta(List<Resposta> respostas) {
		session.getCurrentSession().save(respostas);
	}
	
}
