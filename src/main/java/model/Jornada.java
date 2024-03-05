package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JORNADA database table.
 * 
 */
@Entity
@NamedQuery(name="Jornada.findAll", query="SELECT j FROM Jornada j")
public class Jornada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idjornada;

	private String fechafin;

	private String fechainicio;

	private String nombre;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="jornada")
	private List<Partido> partidos;

	public Jornada() {
	}

	public long getIdjornada() {
		return this.idjornada;
	}

	public void setIdjornada(long idjornada) {
		this.idjornada = idjornada;
	}

	public String getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public Partido addPartido(Partido partido) {
		getPartidos().add(partido);
		partido.setJornada(this);

		return partido;
	}

	public Partido removePartido(Partido partido) {
		getPartidos().remove(partido);
		partido.setJornada(null);

		return partido;
	}

}