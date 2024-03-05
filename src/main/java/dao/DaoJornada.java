package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Jornada;

public class DaoJornada extends BaseJPADao{
	
	public List<Jornada> listadoJornadas() throws SQLException, Exception{ 
		//este es el que llama al EntityManager
		EntityManager em = getEntityManager(); //abre la conexión con la base de datos
		Query consulta = em.createNamedQuery("Jornada.findAll", Jornada.class); //createNamedQuery para llamar al findAll que está definida en el autor
		//nos estamos trayendo las cosas de la base de datos
		List<Jornada> jornadas = consulta.getResultList();

		for(Jornada jornada:jornadas) {
			em.refresh(jornada);
			//refresh --> actualiza todos los datos de la base de datos
			//flush --> fuerza meter los datos a la base de datos
			//ver mejor la informacion --> PAG 64

		}
		em.close();

		return jornadas;
	}
	
	public Jornada buscarJornada (long jornadaId) {
		EntityManager em = getEntityManager();
		Jornada jornada = em.find(Jornada.class, jornadaId);
		em.close();
		
		return jornada;
	}

}
