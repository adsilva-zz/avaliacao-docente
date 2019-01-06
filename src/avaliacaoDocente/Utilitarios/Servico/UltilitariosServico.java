package avaliacaoDocente.Utilitarios.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avaliacaoDocente.Utilitarios.DAO.UltilitariosDAO;

@Service
public class UltilitariosServico {

	@Autowired
	private UltilitariosDAO servico_util;
	
	public String conversao(String str){
		return servico_util.conversao(str);
	}
}
