package avaliacaoDocente.Usuario.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Curso.Servico.CursoServico;
import avaliacaoDocente.Usuario.DAO.UsuarioDAOImp;
import avaliacaoDocente.Usuario.Model.Logar;
import avaliacaoDocente.Usuario.Model.Usuario;
import avaliacaoDocente.Usuario.Servico.UsuarioServico;
import avaliacaoDocente.Utilitarios.Servico.UltilitariosServico;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioServico servico;
	
	@Autowired
	private UltilitariosServico servico_util;
	
	@Autowired
	private CursoServico servico_curso;
	
	@RequestMapping("/avaliacaodocente")
	public String inicio(Model modelo, HttpServletRequest req){
		if (req.getAttribute("logar")== null){
		Logar logar = new Logar();
		modelo.addAttribute(logar);
		}
		return "/inicio/index";
	}
	
	@RequestMapping("/aluno")
	public String aluno(){
		return "/logado/aluno";
	}
	
	@RequestMapping("/administrador")
	public String administrador(){
		return "/logado/administrador";
	}
	
	@RequestMapping("/coordenador")
	public String coordenador(){
		return "/logado/coordenador";
	}
	
	@RequestMapping("/logar")
	public String logar(@Valid Logar logar, BindingResult result, Model modelo, HttpSession session){
		if(result.hasErrors()){
			return "forward:avaliacaodocente";
		}
		
		Usuario usuario = servico.logar(logar);
		
		if(usuario== null){
			modelo.addAttribute("invalido", "Usuário ou Senha inválido");
			return "forward:avaliacaodocente";	
		}
		
		if(usuario.getTipo_usuario().equals("ADMINISTRADOR")){
			session.setAttribute("logado", usuario);	
			return "redirect:/administrador";
		}
		
		if(usuario.getTipo_usuario().equals("ALUNO")){
			session.setAttribute("logado", usuario);	
			return "redirect:/aluno";
		}
		
		if(usuario.getTipo_usuario().equals("COORDENADOR")){
			session.setAttribute("logado", usuario);	
			return "redirect:/coordenador";
		}
		
		return "forward:avaliacaodocente";
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session){
		session.invalidate();
		return "redirect:avaliacaodocente";
	}
	
	@RequestMapping("/cadcoordenador")
	public String cadCoordenador(HttpServletRequest req, Model modelo){
		if(req.getAttribute("usuario")== null){
			Usuario usuarioview = new Usuario();
			usuarioview.setTipo_usuario("COORDENADOR");
			modelo.addAttribute(usuarioview);	
		}
		
		List<Usuario> usuarios = servico.listarCoordenador("COORDENADOR");
		modelo.addAttribute("usuarios", usuarios);
		
		return "/logado/coordenadores/cadcoordenador";
	}
	
	@RequestMapping("/adicionacoordenador")
	public String adicionaCoordenador(@Valid Usuario usuario,BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:administrador?pagina=cadcoordenador";
		}
		
		if(servico_curso.buscarCurso(usuario.getCurso().getId_curso())== null){
			modelo.addAttribute("mensagem", "Curso inexistente!");
			return "redirect:administrador?pagina=cadcoordenador";
		}
				
		servico.cadastraUsuario(usuario);
		modelo.addAttribute("mensagem", "Coordenador cadastrado com sucesso!");
		
	return "redirect:administrador?pagina=cadcoordenador";
	}
	
	@RequestMapping("/removercoordenador")
	public String removerCoordenador(Usuario usuario, Model modelo){
		servico.removerUsuario(usuario.getId_usuario());
		modelo.addAttribute("mensagem", "Excluído com sucesso!");
		
		return "redirect:administrador?pagina=cadcoordenador";
	}
	
	@RequestMapping("/exibircoordenador")
	public String exibirCoordenador(@Valid Usuario usuario, BindingResult result, Model modelo, HttpServletRequest req){
		if (req.getAttribute("usuario") == null){
			modelo.addAttribute("usuario", servico.buscarUsuario(usuario.getId_usuario()));
		}
		return "/logado/coordenadores/exibircoordenador";
	}
	
	@RequestMapping("/editarcoordenador")
	public String editarCoordenador(@Valid Usuario usuario, BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:administrador?pagina=exibircoordenador";
		}
		
		usuario.setNome_usuario(servico_util.conversao(usuario.getNome_usuario()));
		servico.editarUsuario(usuario);
		modelo.addAttribute("mensagem", "Coordenador editado com sucesso!");
		
		return "redirect:administrador?pagina=cadcoordenador";
	}
}
