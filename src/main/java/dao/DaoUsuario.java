package dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Usuario;


public class DaoUsuario extends BaseJPADao{
	
	public Usuario buscarUsuario (String dni) throws SQLException, Exception{
		EntityManager em = getEntityManager();
		Usuario usuario = em.find(Usuario.class, dni);
		em.close();
		
		return usuario;
	}
	
	public void addUsuario(Usuario usuario) throws SQLException, Exception{
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(usuario);
		tx.commit();
		em.close();
		
	}

}
