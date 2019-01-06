package avaliacaoDocente.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import avaliacaoDocente.Usuario.Servico.UsuarioServico;

@Controller
public class CursoController {


	@Autowired
	private UsuarioServico servico;
	
	
}
