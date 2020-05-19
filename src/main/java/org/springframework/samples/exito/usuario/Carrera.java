package org.springframework.samples.exito.usuario;

import org.springframework.samples.exito.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera extends BaseEntity {

	@Column(name = "nivel")
	private String nivel;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "dpto")
	private String dpto;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "institucion")
	private String institucion;

	@Column(name = "sigla")
	private String sigla;

	@Column(name = "area")
	private String area;

	@Column(name = "pago")
	private String pago;

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Carrera{" + "nivel='" + nivel + '\'' + ", nombre='" + nombre + '\'' + ", dpto='" + dpto + '\''
				+ ", localidad='" + localidad + '\'' + ", institucion='" + institucion + '\'' + ", sigla='" + sigla
				+ '\'' + ", area='" + area + '\'' + ", pago='" + pago + '\'' + '}';
	}

}
