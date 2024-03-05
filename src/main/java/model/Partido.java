package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PARTIDO database table.
 * 
 */
@Entity
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idpartido;

	private String fecha;

	private BigDecimal goleslocal;

	private BigDecimal golesvisitante;

	private String hora;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="\"LOCAL\"")
	private Equipo equipo1;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="VISITANTE")
	private Equipo equipo2;

	//bi-directional many-to-one association to Jornada
	@ManyToOne
	@JoinColumn(name="IDJORNADA")
	private Jornada jornada;

	//bi-directional many-to-one association to Porra
	@OneToMany(mappedBy="partido")
	private List<Porra> porras;

	public Partido() {
	}

	public long getIdpartido() {
		return this.idpartido;
	}

	public void setIdpartido(long idpartido) {
		this.idpartido = idpartido;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Jornada getJornada() {
		return this.jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public List<Porra> getPorras() {
		return this.porras;
	}

	public void setPorras(List<Porra> porras) {
		this.porras = porras;
	}

	public Porra addPorra(Porra porra) {
		getPorras().add(porra);
		porra.setPartido(this);

		return porra;
	}

	public Porra removePorra(Porra porra) {
		getPorras().remove(porra);
		porra.setPartido(null);

		return porra;
	}

}