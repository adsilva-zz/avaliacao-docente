package avaliacaoDocente.Usuario.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Resposta.Model.Resposta;
import avaliacaoDocente.Usuario.DAO.UsuarioDAO;
import avaliacaoDocente.Usuario.Model.Logar;
import avaliacaoDocente.Usuario.Model.Usuario;

@Service
@Transactional
public class UsuarioServico {

	@Autowired
	private UsuarioDAO servico_usuario;
	
	public void cadastraUsuario(Usuario usuario) {
		servico_usuario.cadastraUsuario(usuario);
	}

	public void editarUsuario(Usuario usuario) {
		servico_usuario.editarUsuario(usuario);
	}

	public void removerUsuario(long id_usuario) {
		servico_usuario.removerUsuario(id_usuario);
	}

	public List<Usuario> listarUsuarios() {
		return servico_usuario.listarUsuarios();
	}

	public Usuario buscarUsuario(long id_usuario) {
		return servico_usuario.buscarUsuario(id_usuario);
	}

	public Usuario logar(Logar logar) {
		return servico_usuario.logar(logar);
	}

	public void trocarSenha(String senhaantiga, String senhanova) {
		//

	}
	
	public void responderPerguntas(Resposta resposta) {
		// TODO Auto-generated method stub
		
	}

	public void gerarRelatorio() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Usuario> usuarioCurso(long id_curso){
		return servico_usuario.usuarioCurso(id_curso);
	}
	
	public List<Usuario> listarCoordenador(String tipo_usuario){
		return servico_usuario.listarCoordenador(tipo_usuario);
	}

}
