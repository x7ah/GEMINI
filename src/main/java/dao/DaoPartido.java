package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Partido;

public class DaoPartido extends BaseJPADao{

	public List<Partido> getPartidoPorJornada(long idJornada) throws SQLException, Exception{
		EntityManager em = getEntityManager();
		List<Partido> listadoPartidos = null;

		String textoConsulta = "SELECT p FROM Partido p WHERE p.jornada.idjornada = :idjornada";

		TypedQuery<Partido> consulta = em.createQuery(textoConsulta,Partido.class);
		consulta.setParameter("idjornada", idJornada);
		listadoPartidos = consulta.getResultList();

		em.close();
		return listadoPartidos;

	}

}
