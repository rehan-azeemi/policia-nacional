package com.sistema.de.consulatas.dto;

import com.sistema.de.consulatas.enums.Documento;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class SantoDomingoDto implements Serializable {

    private Long id;

    private String fecha;
    
    private MultipartFile foto;
    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String apellidos;
    
    private String nacionalidad;
    
    private String oficioNumero;
    
    private String detalle;
    
    private String otros;
    
    private MultipartFile attachment;
    
    private String fechaDeOficio;
    
    private Documento documento;
    
    private String documentoNumero;
    
    

    public String getDocumentoNumero() {
		return documentoNumero;
	}

	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
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

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
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
