package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String nombre;

	//bi-directional many-to-one association to Porra
	@OneToMany(mappedBy="usuario")
	private List<Porra> porras;

	public Usuario() {
		
	}
	
	public Usuario(String dni) {
		this.dni=dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Porra> getPorras() {
		return this.porras;
	}

	public void setPorras(List<Porra> porras) {
		this.porras = porras;
	}

	public Porra addPorra(Porra porra) {
		getPorras().add(porra);
		porra.setUsuario(this);

		return porra;
	}

	public Porra removePorra(Porra porra) {
		getPorras().remove(porra);
		porra.setUsuario(null);

		return porra;
	}

}