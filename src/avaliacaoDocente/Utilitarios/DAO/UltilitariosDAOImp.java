package avaliacaoDocente.Utilitarios.DAO;

import java.text.Normalizer;

import org.springframework.stereotype.Repository;

@Repository
public class UltilitariosDAOImp implements UltilitariosDAO{

	@Override
	public String conversao(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		str = str.toUpperCase();
		
		return str;
	}

}
