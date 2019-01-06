package avaliacaoDocente.Disciplina.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Curso.Servico.CursoServico;
import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Disciplina.Servico.Disc_ProfServico;
import avaliacaoDocente.Disciplina.Servico.DisciplinaServico;
import avaliacaoDocente.Usuario.Model.Usuario;
import avaliacaoDocente.Utilitarios.Servico.UltilitariosServico;

@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaServico servico;
	
	@Autowired
	private CursoServico servico_curso;
	
	@Autowired
	private Disc_ProfServico servico_disc_prof;
	
	@Autowired
	private UltilitariosServico servico_util;
	
	@ModelAttribute("periodos")
	public List<String> todosPeriodos(){
		List<String> periodos = new ArrayList<>();
		periodos.add("MATUTINO");
		periodos.add("VESPERTINO");
		periodos.add("NOTURNO");
		return periodos;
	}
	
	@RequestMapping("/disciplina")
	public String disciplina(HttpServletRequest req, Model modelo, HttpSession session){
		if(req.getAttribute("disciplina") == null){
			Disciplina disview = new Disciplina();
			modelo.addAttribute("disciplina", disview);
		}

		Usuario logado = (Usuario)session.getAttribute("logado");
		List<Disciplina> disciplinas = servico.disciplinaCurso(logado.getCurso().getId_curso());
		modelo.addAttribute("disciplinas", disciplinas);
		return "/logado/disciplinas/disciplina";	
	}
	
	@RequestMapping("/adicionadisciplina")
	public String adicionaDisciplina(@Valid Disciplina disciplina, BindingResult result, 
			Model modelo, HttpSession session){
		if(result.hasErrors()){
			return "forward:coordenador?pagina=disciplina";
		}
		
		disciplina.setNome_disciplina(servico_util.conversao(disciplina.getNome_disciplina()));
		
		if(!servico.existeDisciplina(disciplina.getNome_disciplina(), disciplina.getPeriodo_disciplina()).isEmpty()){
			modelo.addAttribute("mensagem", "Disciplina já cadastrada!");
			return "redirect:coordenador?pagina=disciplina";
		}

		Usuario logado = (Usuario)session.getAttribute("logado");
		Curso curso = logado.getCurso();
		disciplina.setCursos(curso);
		
		servico.cadastraDisciplina(disciplina);
		modelo.addAttribute("mensagem", "Cadastrado com sucesso!");
		
		List<Disciplina> disciplinas = servico.disciplinaCurso(logado.getCurso().getId_curso());
		modelo.addAttribute("disciplinas", disciplinas);
		return "redirect:coordenador?pagina=disciplina";
	}
	
	@RequestMapping("exibirdisciplina")
	public String exibirDisciplina(@Valid Disciplina disciplina, BindingResult result, Model modelo, HttpServletRequest req){
		if(req.getAttribute("disciplina") == null){
			modelo.addAttribute("disciplina", servico.buscarDisciplina(disciplina.getId_disciplina()));			
		}
		return "/logado/disciplinas/exibirdisciplina";
	}
	
	@RequestMapping("/editardisciplina")
	public String editarDisciplina(@Valid Disciplina disciplina, BindingResult result, Model modelo, HttpSession session){
		if(result.hasErrors()){
			return "forward:./coordenador?pagina=exibirdisciplina";
		}
		
		Usuario logado = (Usuario)session.getAttribute("logado");
		Curso curso = logado.getCurso();
		disciplina.setCursos(curso);
		
		disciplina.setNome_disciplina(servico_util.conversao(disciplina.getNome_disciplina()));
		
		servico.editarDisciplina(disciplina);
		modelo.addAttribute("mensagem", "Disciplina editada com sucesso!");
		
		return "redirect:coordenador?pagina=disciplina";
	}
	
	@RequestMapping("/removerdisciplina")
	public String removerDisciplina(Disciplina disciplina, Model modelo){
		List<Disciplina_Professor> disc = servico_disc_prof.disc_proDisciplina(disciplina.getId_disciplina());
		for(Disciplina_Professor ldisc : disc){
			servico_disc_prof.removerDiscPro(ldisc.getId_disc_pro());
		}
		
		servico.removerDisciplina(disciplina.getId_disciplina());
		modelo.addAttribute("mensagem", "Excluído com sucesso!");
		
		return "redirect:coordenador?pagina=disciplina";
	}
}
