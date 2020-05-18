package com.sistema.de.consulatas.dto;

import org.springframework.web.multipart.MultipartFile;

import com.sistema.de.consulatas.enums.Documento;

public class SantoDomingoJRBean {
	private String fecha;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String apellidos;
    
    private String nacionalidad;
    
    private String oficioNumero;
    
    private String detalle;
    
    private String otros;
    
    private String fechaDeOficio;
    
    private String documento;
    
    private String documentoNumero;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getFechaDeOficio() {
		return fechaDeOficio;
	}

	public void setFechaDeOficio(String fechaDeOficio) {
		this.fechaDeOficio = fechaDeOficio;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDocumentoNumero() {
		return documentoNumero;
	}

	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}
}
