package avaliacaoDocente.Usuario.DAO;

import java.util.List;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Resposta.Model.Resposta;
import avaliacaoDocente.Usuario.Model.Logar;
import avaliacaoDocente.Usuario.Model.Usuario;

public interface UsuarioDAO {

	public Usuario logar(Logar logar);

	public void trocarSenha(String senhaantiga, String senhanova);
	
	public void cadastraUsuario(Usuario usuario);

	public void editarUsuario(Usuario usuario);

	public void removerUsuario(long id_usuario);

	public List<Usuario> listarUsuarios();

	public List<Usuario> listarCoordenador(String tipo_usuario);
	
	public Usuario buscarUsuario(long id_usuario);

	public void responderPerguntas(Resposta resposta);
	
	public void gerarRelatorio();
	
	public List<Usuario> usuarioCurso(long id_curso);
	
}
