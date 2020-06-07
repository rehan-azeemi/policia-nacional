package com.sistema.de.consulatas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sistema.de.consulatas.enums.Documento;

@Entity
public class SantoDomingo extends BaseEntity{

	@Column
	private String fecha;
	@Column
	private String fotoPath;
	@Column
	private String primerNombre;
	@Column
	private String segundoNombre;
	@Column
	private String apellidos;
	@Column
	private String nacionalidad;
	@Column
	private String oficioNumero;
	@Column
	private String ARequerimiento;
	@Column
	private String otros;
	@Column
	private String attachment;
	@Column
	private String fechaDeOficio;
	@Column
	private Documento documento;
	@Column
	private String documentoNumero;
	@Column
	private String fechaDeNacimiento;
	@Column
	private String entidadSolicitante;
	@Column
	private String noDeOficio;
	public static int srNo = 0;
	
	public int getSrNo() {
		return ++srNo;
	}

	public String getNoDeOficio() {
		return noDeOficio;
	}
	public void setNoDeOficio(String noDeOficio) {
		this.noDeOficio = noDeOficio;
	}
	public String getEntidadSolicitante() {
		return entidadSolicitante;
	}
	public void setEntidadSolicitante(String entidadSolicitante) {
		this.entidadSolicitante = entidadSolicitante;
	}
	public String getARequerimiento() {
		return ARequerimiento;
	}
	public void setARequerimiento(String aRequerimiento) {
		ARequerimiento = aRequerimiento;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getDocumentoNumero() {
		return documentoNumero;
	}
	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFotoPath() {
		return fotoPath;
	}
	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getOficioNumero() {
		return oficioNumero;
	}
	public void setOficioNumero(String oficioNumero) {
		this.oficioNumero = oficioNumero;
	}
	
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getFechaDeOficio() {
		return fechaDeOficio;
	}
	public void setFechaDeOficio(String fechaDeOficio) {
		this.fechaDeOficio = fechaDeOficio;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
}
