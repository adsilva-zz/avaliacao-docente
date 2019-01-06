package avaliacaoDocente.Resposta.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Resposta.DAO.RespostaDAO;
import avaliacaoDocente.Resposta.Model.Resposta;

@Service
@Transactional
public class RespostaServico {
	@Autowired
	private RespostaDAO servico_resposta;
	
	public void salvarResposta(List<Resposta> respostas){
		servico_resposta.salvarResposta(respostas);
	}
}
