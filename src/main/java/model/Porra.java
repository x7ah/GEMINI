package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PORRA database table.
 * 
 */
@Entity
@NamedQuery(name="Porra.findAll", query="SELECT p FROM Porra p")
public class Porra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PorraPK id;

	private BigDecimal goleslocal;

	private BigDecimal golesvisitante;

	//bi-directional many-to-one association to Partido
	@ManyToOne
	@JoinColumn(name="IDPARTIDO")
	private Partido partido;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuario usuario;

	public Porra() {
	}

	public PorraPK getId() {
		return this.id;
	}

	public void setId(PorraPK id) {
		this.id = id;
	}

	public BigDecimal getGoleslocal() {
		return this.goleslocal;
	}

	public void setGoleslocal(BigDecimal goleslocal) {
		this.goleslocal = goleslocal;
	}

	public BigDecimal getGolesvisitante() {
		return this.golesvisitante;
	}

	public void setGolesvisitante(BigDecimal golesvisitante) {
		this.golesvisitante = golesvisitante;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}