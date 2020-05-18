package org.springframework.samples.exito.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.exito.model.BaseEntity;

@Entity
@Table(name = "razonamiento")
public class Razonamiento extends BaseEntity {

	@Column(name = "fechallenado")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechallenado;

	@Column(name = "usuarioraz")
	private String usuarioraz;

	@Column(name = "resultado")
	private Integer resultado;

	public LocalDate getFechallenado() {
		return this.fechallenado;
	}

	public Integer getResultado() {
		return this.resultado;
	}

	public void setFechallenado(LocalDate fechallenado) {
		this.fechallenado = fechallenado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	public String getUsuarioraz() {
		return usuarioraz;
	}

	public void setUsuarioraz(String usuarioraz) {
		this.usuarioraz = usuarioraz;
	}

}
