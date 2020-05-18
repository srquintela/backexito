package org.springframework.samples.exito.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.exito.model.BaseEntity;

@Entity
@Table(name = "usuarios")
public class Usuario extends BaseEntity {

	@Column(name = "username")
	@NotEmpty
	private String username;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Column(name = "ueducativa")
	private String ueducativa;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fechanac")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechanac;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "grado")
	private String grado;

	@Column(name = "nivel")
	private String nivel;

	@Column(name = "dpto")
	private String dpto;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "email")
	private String email;

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUeducativa() {
		return this.ueducativa;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public LocalDate getFechanac() {
		return this.fechanac;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getGrado() {
		return this.grado;
	}

	public String getNivel() {
		return this.nivel;
	}

	public String getDpto() {
		return this.dpto;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUeducativa(String ueducativa) {
		this.ueducativa = ueducativa;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.getId()).append("new", this.isNew())
				.append("username", this.getUsername()).append("password", this.getPassword())
				.append("ueducativa", this.ueducativa).append("nombre", this.nombre).append("apellidos", this.apellidos)
				.toString();
	}

}
