package avaliacaoDocente.Pergunta.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import avaliacaoDocente.Pergunta.Model.Pergunta;
import avaliacaoDocente.Pergunta.Servico.PerguntaServico;

@Controller
public class PerguntaController {

	@Autowired
	private PerguntaServico servico;

	@RequestMapping("/pergunta")
	public String pergunta(HttpServletRequest req, Model modelo) {
		if (req.getAttribute("pergunta") == null) {
			Pergunta perguntaview = new Pergunta();
			modelo.addAttribute(perguntaview);
		}
		List<Pergunta> perguntas = servico.listarPerguntas();
		modelo.addAttribute("perguntas", perguntas);

		return "/logado/perguntas/pergunta";
	}

	@RequestMapping("/adicionapergunta")
	public String adicionaPergunta(@ Valid Pergunta pergunta, BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:administrador?pagina=pergunta";
		}
		List<Pergunta> perguntas = servico.listarPerguntas();
		modelo.addAttribute("perguntas", perguntas);
		
		servico.cadastraPergunta(pergunta);
		modelo.addAttribute("mensagem", "Cadastrado com sucesso!");
		
		return "redirect:administrador?pagina=pergunta";
	}
	
	@RequestMapping("/exibirpergunta")
	public String exibirPergunta(@Valid Pergunta pergunta, BindingResult result, Model modelo, HttpServletRequest req){
		if(req.getAttribute("pergunta") == null){
			modelo.addAttribute("pergunta", servico.buscarPergunta(pergunta.getId_pergunta()));
		}
		
		return"/logado/perguntas/exibirpergunta";
	}
	
	@RequestMapping("/editarpergunta")
	public String editarPergunta(@ Valid Pergunta pergunta, BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:administrador?pagina=exibirpergunta";
		}
		
		servico.editarPergunta(pergunta);
		modelo.addAttribute("mensagem", "Pergunta editada com sucesso!");
		return "redirect:administrador?pagina=pergunta";
	}
	
	@RequestMapping("/removerpergunta")
	public String removerPergunta(Pergunta pergunta, Model modelo){
		servico.removerPergunta(pergunta.getId_pergunta());
		modelo.addAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:administrador?pagina=pergunta";
	}
}
