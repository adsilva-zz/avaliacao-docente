package avaliacaoDocente.Usuario.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Resposta.Model.Resposta;
import avaliacaoDocente.Usuario.Model.Logar;
import avaliacaoDocente.Usuario.Model.Usuario;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void cadastraUsuario(Usuario usuario) {
		session.getCurrentSession().save(usuario);
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		session.getCurrentSession().merge(usuario);
	}

	@Override
	public void removerUsuario(long id_usuario) {
		session.getCurrentSession().delete(buscarUsuario(id_usuario));
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return session.getCurrentSession().createCriteria(Usuario.class).addOrder(Order.asc("nome_usuario")).list();
	}

	@Override
	public List<Usuario> listarCoordenador(String tipo_usuario) {
		return session.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.like("tipo_usuario", tipo_usuario, MatchMode.EXACT)).addOrder(Order.asc("nome_usuario")).list();
	}

	@Override
	public Usuario buscarUsuario(long id_usuario) {
		return (Usuario) session.getCurrentSession().get(Usuario.class,
				id_usuario);
	}

	@Override
	public Usuario logar(Logar logar) {
		return (Usuario)session.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("logar.login_usuario", logar.getLogin_usuario()))
				.add(Restrictions.eq("logar.senha_usuario", logar.getSenha_usuario())).uniqueResult();
	}
	
	@Override
	public void trocarSenha(String senhaantiga, String senhanova) {
		//

	}

	@Override
	public void responderPerguntas(Resposta resposta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gerarRelatorio() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> usuarioCurso(long id_curso) {
		Curso lista = (Curso) session.getCurrentSession().get(Curso.class, id_curso);
		return lista.getUsuarios();
		
	}

}
