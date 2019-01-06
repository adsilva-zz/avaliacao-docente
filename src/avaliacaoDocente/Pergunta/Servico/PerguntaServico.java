package avaliacaoDocente.Pergunta.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Pergunta.DAO.PerguntaDAO;
import avaliacaoDocente.Pergunta.Model.Pergunta;
import avaliacaoDocente.Usuario.Model.Usuario;

@Service
@Transactional

public class PerguntaServico {

	@Autowired
	private PerguntaDAO servico_pergunta;
	
	public void cadastraPergunta(Pergunta pergunta) {
		servico_pergunta.cadastraPergunta(pergunta);
	}

	public void editarPergunta(Pergunta pergunta) {
		servico_pergunta.editarPergunta(pergunta);		
	}

	public void removerPergunta(long id_pergunta) {
		servico_pergunta.removerPergunta(id_pergunta);
	}

	public List<Pergunta> listarPerguntas() {
		return servico_pergunta.listarPerguntas();
	}

	public Pergunta buscarPergunta(long id_pergunta) {
		return servico_pergunta.buscarPergunta(id_pergunta);
	}
}
