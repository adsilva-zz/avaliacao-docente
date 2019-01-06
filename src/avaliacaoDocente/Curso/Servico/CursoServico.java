package avaliacaoDocente.Curso.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avaliacaoDocente.Curso.DAO.CursoDAO;
import avaliacaoDocente.Curso.Model.Curso;

@Service
@Transactional
public class CursoServico {

	@Autowired
	private CursoDAO servi_curso;
	
	public void cadastrarCurso(Curso curso) {
		servi_curso.cadastrarCurso(curso);
	}

	public void editarCurso(Curso curso) {
		servi_curso.editarCurso(curso);
	}

	public void removerCurso(long id_cursoo) {
		servi_curso.removerCurso(id_cursoo);
	}

	public List<Curso> listarCursos() {
		return servi_curso.listarCursos();
	}

	public Curso buscarCurso(long id_curso) {
		return servi_curso.buscarCurso(id_curso);
	}
}
