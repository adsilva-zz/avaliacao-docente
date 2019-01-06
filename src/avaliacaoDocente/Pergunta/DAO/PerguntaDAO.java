package avaliacaoDocente.Pergunta.DAO;

import java.util.List;

import avaliacaoDocente.Pergunta.Model.Pergunta;
import avaliacaoDocente.Pergunta.Model.Pergunta_Disciplina;
import avaliacaoDocente.Usuario.Model.Usuario;

public interface PerguntaDAO {

	public void cadastraPergunta(Pergunta pergunta);

	public void editarPergunta(Pergunta pergunta);

	public void removerPergunta(long id_pergunta);

	public List<Pergunta> listarPerguntas();

	public Pergunta buscarPergunta(long id_pergunta);

}
