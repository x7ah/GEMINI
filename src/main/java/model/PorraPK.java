package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PORRA database table.
 * 
 */
@Embeddable
public class PorraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String dni;

	@Column(insertable=false, updatable=false)
	private long idpartido;

	public PorraPK() {
	}
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public long getIdpartido() {
		return this.idpartido;
	}
	public void setIdpartido(long idpartido) {
		this.idpartido = idpartido;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PorraPK)) {
			return false;
		}
		PorraPK castOther = (PorraPK)other;
		return 
			this.dni.equals(castOther.dni)
			&& (this.idpartido == castOther.idpartido);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dni.hashCode();
		hash = hash * prime + ((int) (this.idpartido ^ (this.idpartido >>> 32)));
		
		return hash;
	}
}