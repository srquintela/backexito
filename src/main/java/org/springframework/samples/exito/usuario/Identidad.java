package org.springframework.samples.exito.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.exito.model.BaseEntity;

@Entity
@Table(name = "identidad")
public class Identidad extends BaseEntity {

	@Column(name = "fechallenado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechallenado;

	@Column(name = "usuarioide")
	private String usuarioide;

	@Column(name = "compromiso")
	private Integer compromiso;

	@Column(name = "identificacion")
	private Integer identificacion;

	@Column(name = "flexibilidad")
	private Integer flexibilidad;

	@Column(name = "dudas")
	private Integer dudas;

	@Column(name = "anchoexplo")
	private Integer anchoexplo;

	@Column(name = "profexplo")
	private Integer profexplo;

	public LocalDate getFechallenado() {
		return this.fechallenado;
	}

	public String getUsuario() {
		return this.usuarioide;
	}

	public Integer getCompromiso() {
		return this.compromiso;
	}

	public void setCompromiso(Integer compromiso) {
		this.compromiso = compromiso;
	}

	public Integer getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getFlexibilidad() {
		return this.flexibilidad;
	}

	public void setFlexibilidad(Integer flexibilidad) {
		this.flexibilidad = flexibilidad;
	}

	public Integer getDudas() {
		return this.dudas;
	}

	public void setDudas(Integer dudas) {
		this.dudas = dudas;
	}

	public Integer getAnchoexplo() {
		return this.anchoexplo;
	}

	public void setAnchoexplo(Integer anchoexplo) {
		this.anchoexplo = anchoexplo;
	}

	public Integer getProfexplo() {
		return this.profexplo;
	}

	public void setProfexplo(Integer profexplo) {
		this.profexplo = profexplo;
	}

	public void setFechallenado(LocalDate fechallenado) {
		this.fechallenado = fechallenado;
	}

	public void setUsuario(String usuarioide) {
		this.usuarioide = usuarioide;
	}

}
