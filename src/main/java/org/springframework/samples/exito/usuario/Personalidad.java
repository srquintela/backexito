package org.springframework.samples.exito.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.exito.model.BaseEntity;

@Entity
@Table(name = "personalidad")
public class Personalidad extends BaseEntity {

	@Column(name = "fechallenado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechallenado;

	@Column(name = "usuarioper")
	private String usuarioper;

	@Column(name = "extroversion")
	private Integer extroversion;

	@Column(name = "creatividad")
	private Integer creatividad;

	@Column(name = "responsabilidad")
	private Integer responsabilidad;

	@Column(name = "afabilidad")
	private Integer afabilidad;

	@Column(name = "neurotismo")
	private Integer neurotismo;

	public LocalDate getFechallenado() {
		return this.fechallenado;
	}

	public Integer getExtroversion() {
		return this.extroversion;
	}

	public void setExtroversion(Integer extroversion) {
		this.extroversion = extroversion;
	}

	public Integer getCreatividad() {
		return this.creatividad;
	}

	public void setCreatividad(Integer creatividad) {
		this.creatividad = creatividad;
	}

	public Integer getResponsabilidad() {
		return this.responsabilidad;
	}

	public void setResponsabilidad(Integer responsabilidad) {
		this.responsabilidad = responsabilidad;
	}

	public Integer getAfabilidad() {
		return afabilidad;
	}

	public void setAfabilidad(Integer afabilidad) {
		this.afabilidad = afabilidad;
	}

	public Integer getNeurotismo() {
		return neurotismo;
	}

	public void setNeurotismo(Integer neurotismo) {
		this.neurotismo = neurotismo;
	}

	public void setFechallenado(LocalDate fechallenado) {
		this.fechallenado = fechallenado;
	}

	public String getUsuarioper() {
		return usuarioper;
	}

	public void setUsuarioper(String usuarioper) {
		this.usuarioper = usuarioper;
	}

}
