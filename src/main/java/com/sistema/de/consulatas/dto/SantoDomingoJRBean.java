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
    
    private String ARequerimiento;
    
    private String otros;
    
    private String fechaDeOficio;
    
    private String documento;
    
    private String documentoNumero;
    
    private String entidadSolicitante;
    
    private String active;
    
    private String fechaDeNacimiento;
    
    private String noDeOficio;
    
    private String imagePath;
    
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getNoDeOficio() {
		return noDeOficio;
	}
	public void setNoDeOficio(String noDeOficio) {
		this.noDeOficio = noDeOficio;
	}
    
    public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getEntidadSolicitante() {
		return entidadSolicitante;
	}
	public void setEntidadSolicitante(String entidadSolicitante) {
		this.entidadSolicitante = entidadSolicitante;
	}

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

	public String getARequerimiento() {
		return ARequerimiento;
	}

	public void setARequerimiento(String detalle) {
		this.ARequerimiento = detalle;
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
