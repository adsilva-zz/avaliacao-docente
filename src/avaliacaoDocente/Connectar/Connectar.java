package avaliacaoDocente.Connectar;

import javax.persistence.Persistence;

public class Connectar {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("amanda").createEntityManager();
	
	}
}
