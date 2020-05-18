package org.springframework.samples.exito.usuario;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Respuesta {

	private String codigo;

	private String mensaje;

	private Object objeto;

	public Respuesta() {
	}

	public Respuesta(String codigo, String mensaje, Object objeto) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.objeto = objeto;
	}

	public static Respuesta respuesta(String vCodigo, String vMensaje, Object vObjeto) {
		return new Respuesta(vCodigo, vMensaje, vObjeto);
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public Object getObjeto() {
		return this.objeto;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

}
