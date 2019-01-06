package avaliacaoDocente.Professor.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import avaliacaoDocente.Curso.Model.Curso;
import avaliacaoDocente.Disciplina.Model.Disciplina;
import avaliacaoDocente.Disciplina.Model.Disciplina_Professor;
import avaliacaoDocente.Disciplina.Servico.Disc_ProfServico;
import avaliacaoDocente.Disciplina.Servico.DisciplinaServico;
import avaliacaoDocente.Professor.Model.Professor;
import avaliacaoDocente.Professor.Servico.ProfessorServico;
import avaliacaoDocente.Usuario.Model.Usuario;
import avaliacaoDocente.Utilitarios.DAO.UltilitariosDAO;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorServico servico;

	@Autowired
	private Disc_ProfServico servico_disc_prof;

	@Autowired
	private DisciplinaServico servico_disc;

	@Autowired
	private UltilitariosDAO servico_util;

	@RequestMapping("/professor")
	public String professor(Model modelo, HttpSession session) {
		Usuario logado = (Usuario) session.getAttribute("logado");
		List<Professor> professores = servico.professorCurso(logado.getCurso()
				.getId_curso());
		modelo.addAttribute("professores", professores);

		return "/logado/professores/professor";
	}

	@RequestMapping("/professorcadastro")
	public String professorCadastro(HttpServletRequest req, Model modelo,
			HttpSession session) {
		if (req.getAttribute("professor") == null) {
			Professor professor = new Professor();
			modelo.addAttribute("professor", professor);
		}

		Usuario logado = (Usuario) session.getAttribute("logado");
		List<Disciplina> disciplinas = servico_disc.disciplinaCurso(logado
				.getCurso().getId_curso());
		modelo.addAttribute("disciplinas", disciplinas);

		return "/logado/professores/professorcadastro";
	}

	@RequestMapping("/adicionaprofessor")
	public String adicionaProfessor(
			@Valid Professor professor,
			BindingResult result,
			@RequestParam(value = "disciplina", required = false) List<Long> disciplina,
			Model modelo, HttpSession session) {
		if (result.hasErrors()) {
			return "forward:coordenador?pagina=professorcadastro";
		}

		if (disciplina == null || disciplina.isEmpty()) {
			modelo.addAttribute("mensagem",
					"Selecione ao menos uma disciplina!");
			return "redirect:coordenador?pagina=professorcadastro";
		}
		professor.setNome_professor(servico_util.conversao(professor
				.getNome_professor()));

		if (servico.existiProfessor(professor.getNome_professor()).size() > 0) {
			modelo.addAttribute("mensagem", "Professor já cadastrado!");
			return "redirect:coordenador?pagina=professor";
		}
		Usuario logado = (Usuario) session.getAttribute("logado");
		Curso curso = logado.getCurso();
		professor.setCursos(curso);

		servico.cadastrarProfessor(professor);

		Disciplina_Professor disc_prof = new Disciplina_Professor();
		if (disciplina.size() >= 1) {
			for (long ldisc : disciplina) {
				disc_prof.setDisciplina(servico_disc.buscarDisciplina(ldisc));
				disc_prof.setProfessor(servico.buscarProfessor(professor
						.getId_professor()));
				servico_disc_prof.cadastraDiscPro(disc_prof);
			}
		}
		return "forward:coordenador?pagina=professor";

	}

	@RequestMapping("/removerprofessor")
	public String removerProfessor(Professor professor, Model modelo) {
		List<Disciplina_Professor> prof = servico_disc_prof
				.disc_proProfessor(professor.getId_professor());
		for (Disciplina_Professor pro : prof) {
			servico_disc_prof.removerDiscPro(pro.getId_disc_pro());
		}

		servico.removerProfessor(professor.getId_professor());
		modelo.addAttribute("mensagem", "Excluído com sucesso!");

		return "redirect:coordenador?pagina=professor";
	}

	@RequestMapping("/exibirprofessor")
	public String exibirProfessor(@Valid Professor professor,
			BindingResult result, Model modelo, HttpServletRequest req) {
		List<Disciplina_Professor> lista = new ArrayList<>();
		if (req.getAttribute("professor") == null) {
			modelo.addAttribute("professor",
					servico.buscarProfessor(professor.getId_professor()));
			lista = servico_disc_prof.disc_proProfessor(professor
					.getId_professor());
		}

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Disciplina_Professor dis : lista) {
			disciplinas.add(dis.getDisciplina());
		}
		List<Disciplina> alldisc = servico_disc.listarDisciplinas();
		for (Disciplina disc : alldisc) {
			if (disciplinas.contains(disc)) {
				disc.setContem(true);
			}
		}		
		modelo.addAttribute("alldisc", alldisc);

		return "/logado/professores/exibirprofessor";
	}

	@RequestMapping("/editarprofessor")
	public String editarProfessor(
			@Valid Professor professor,
			BindingResult result,
			@RequestParam(value = "disciplina", required = false) List<Long> disciplina,
			Model modelo, HttpSession session) {
		
		if (result.hasErrors()) {
			return "forward:coordenador?pagina=exibirprofessor";
		}

		if (disciplina == null) {
			modelo.addAttribute("mensagem",
					"Seleciona ao menos uma disciplina!");
			return "forward:coordenador?pagina=exibirprofessor";
		}

		List<Disciplina_Professor> lista = servico_disc_prof
				.disc_proProfessor(professor.getId_professor());

		List<Long> disc = new ArrayList<Long>();
		for (Disciplina_Professor dispro : lista) {
			disc.add(dispro.getDisciplina().getId_disciplina());
		}

		Disciplina_Professor disc_prof = new Disciplina_Professor();

		for (Long x : disciplina) {
			if (!disc.contains(x)) {
				disc_prof.setDisciplina(servico_disc.buscarDisciplina(x));
				disc_prof.setProfessor(professor);
				servico_disc_prof.cadastraDiscPro(disc_prof);
			} else {
				disc.remove(x);
			}
		}
		for (Long teste : disc) {
			servico_disc_prof.removeDiscPro(teste, professor.getId_professor());
		}

		Usuario logado = (Usuario) session.getAttribute("logado");
		Curso curso = logado.getCurso();
		professor.setCursos(curso);
		servico.editarProfessor(professor);
		modelo.addAttribute("mensagem", "Professor editado com sucesso!");

		return "redirect:./coordenador?pagina=professor";
	}
}
