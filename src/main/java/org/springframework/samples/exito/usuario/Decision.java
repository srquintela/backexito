package org.springframework.samples.exito.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.exito.model.BaseEntity;

@Entity
@Table(name = "decision")
public class Decision extends BaseEntity {

	@Column(name = "fechallenado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechallenado;

	@Column(name = "usuariodec")
	private String usuariodec;

	@Column(name = "fuente")
	private String fuente;

	@Column(name = "racional")
	private Integer racional;

	@Column(name = "intuitivo")
	private Integer intuitivo;

	@Column(name = "evasivo")
	private Integer evasivo;

	@Column(name = "espontaneo")
	private Integer espontaneo;

	@Column(name = "dependiente")
	private Integer dependiente;

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Decision() {
		this.fechallenado = LocalDate.now();
	}

	public String getUsuariodec() {
		return usuariodec;
	}

	public void setUsuariodec(String usuariodec) {
		this.usuariodec = usuariodec;
	}

	public LocalDate getFechallenado() {
		return this.fechallenado;
	}

	public Integer getRacional() {
		return racional;
	}

	public void setRacional(Integer racional) {
		this.racional = racional;
	}

	public Integer getIntuitivo() {
		return intuitivo;
	}

	public void setIntuitivo(Integer intuitivo) {
		this.intuitivo = intuitivo;
	}

	public Integer getEvasivo() {
		return evasivo;
	}

	public void setEvasivo(Integer evasivo) {
		this.evasivo = evasivo;
	}

	public Integer getEspontaneo() {
		return espontaneo;
	}

	public void setEspontaneo(Integer espontaneo) {
		this.espontaneo = espontaneo;
	}

	public Integer getDependiente() {
		return dependiente;
	}

	public void setDependiente(Integer dependiente) {
		this.dependiente = dependiente;
	}

	public void setFechallenado(LocalDate fechallenado) {
		this.fechallenado = fechallenado;
	}

	@Override
	public String toString() {
		return "Decision{" + "fechallenado=" + fechallenado + ", usuariodec='" + usuariodec + '\'' + ", fuente='"
				+ fuente + '\'' + ", racional=" + racional + ", intuitivo=" + intuitivo + ", evasivo=" + evasivo
				+ ", espontaneo=" + espontaneo + ", dependiente=" + dependiente + '}';
	}

}
