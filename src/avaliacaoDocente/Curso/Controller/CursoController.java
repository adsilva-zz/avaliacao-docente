package avaliacaoDocente.Curso.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Curso.Servico.CursoServico;
import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Disciplina.Servico.Disc_ProfServico;
import avaliacaoDocente.Disciplina.Servico.DisciplinaServico;
import avaliacaoDocente.Professor.Model.Professor;
import avaliacaoDocente.Professor.Servico.ProfessorServico;
import avaliacaoDocente.Usuario.Model.Usuario;
import avaliacaoDocente.Usuario.Servico.UsuarioServico;
import avaliacaoDocente.Utilitarios.DAO.UltilitariosDAO;
import avaliacaoDocente.Utilitarios.Servico.UltilitariosServico;

@Controller
public class CursoController {

	@Autowired
	private CursoServico servico;

	@Autowired
	private DisciplinaServico servico_disc;
	
	@Autowired
	private UsuarioServico servico_usuario;
	
	@Autowired
	private UltilitariosServico servico_util;
	
	@Autowired
	private Disc_ProfServico servico_disc_prof;
	
	@Autowired
	private ProfessorServico servico_professor;
	
	@RequestMapping("curso")
	public String curso(HttpServletRequest req, Model modelo) {
		if(req.getAttribute("curso")== null){
			Curso cursoview = new Curso();
			modelo.addAttribute(cursoview);	
		}
		
		List<Curso> cursos = servico.listarCursos();
		modelo.addAttribute("cursos", cursos);
		
		return "/logado/cursos/curso";
	}
	
	@RequestMapping("/adicionacurso")
	public String salvarcurso(@Valid Curso curso, BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:administrador?pagina=curso";
		}

		curso.setNome_curso(servico_util.conversao(curso.getNome_curso()));
		
		if(servico.buscarCurso(curso.getId_curso())!= null){
			modelo.addAttribute("mensagem", "Curso existente!");
			return "redirect:administrador?pagina=curso";
		}
		servico.cadastrarCurso(curso);
		modelo.addAttribute("mensagem", "Cadastrado com sucesso!");
		
		List<Curso> cursos = servico.listarCursos();
		modelo.addAttribute("cursos", cursos);
		
		return "redirect:administrador?pagina=curso";
	}

	@RequestMapping("/removercurso")
	public String removercurso(Curso curso, Model modelo){
		// Excluindo todas as disciplinas deste curso 
		List <Disciplina> disc = servico_disc.disciplinaCurso(curso.getId_curso());
		for (Disciplina ldisc : disc){
			//Excluindo todas as disc_prof de todas as disciplinas deste curso
			List<Disciplina_Professor> discprof = servico_disc_prof.disc_proDisciplina(ldisc.getId_disciplina());
				for(Disciplina_Professor ldiscprof : discprof){
					servico_disc_prof.removerDiscPro(ldiscprof.getId_disc_pro());
			}
			servico_disc.removerDisciplina(ldisc.getId_disciplina());
		}

		// Exclindo todos os usuarios pertencentes a esse curso
		List <Usuario> usuario = servico_usuario.usuarioCurso(curso.getId_curso());
		for (Usuario lusuario : usuario){
				servico_usuario.removerUsuario(lusuario.getId_usuario());				
			}
		
		//Excluindo todos os professores deste curso
		List<Professor> professor = servico_professor.professorCurso(curso.getId_curso());
			for(Professor lprof : professor){
				servico_professor.removerProfessor(lprof.getId_professor());
			}
		
		//Excluir curso
		servico.removerCurso(curso.getId_curso());
		modelo.addAttribute("mensagem", "Excluído com sucesso!");
		
		return"redirect:administrador?pagina=curso";
	}
	
	@RequestMapping("/exibircurso")
	public String exibircurso(@Valid Curso curso, BindingResult result, Model modelo, HttpServletRequest req){
		if (req.getAttribute("curso") == null){
			modelo.addAttribute("curso", servico.buscarCurso(curso.getId_curso()));
		}
		return "/logado/cursos/exibircurso";
	}
	
	@RequestMapping("/editarcurso")
	public String editarcurso(@Valid Curso curso, BindingResult result, Model modelo){
		if(result.hasErrors()){
			return "forward:/administrador?pagina=exibircurso";
		}
		
		curso.setNome_curso(servico_util.conversao(curso.getNome_curso()));
		servico.editarCurso(curso);
		modelo.addAttribute("mensagem", "Curso editado com sucesso!");
		
		return "redirect:administrador?pagina=curso";
	}
}
