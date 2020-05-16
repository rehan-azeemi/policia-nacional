package com.sistema.de.consulatas.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.de.consulatas.enums.Documento;
import com.sistema.de.consulatas.model.*;
import com.sistema.de.consulatas.repository.SantoDomingoRepo;

@Service
public class SantoDomingoService {
	@Autowired
	SantoDomingoRepo santoDomingoRepo;
	
	public void save(SantoDomingo santoDomingo) {
		if(santoDomingo != null) {
			santoDomingoRepo.save(santoDomingo);
		}
	}
	
	public List<String> getAllDocumento(){
		ArrayList<String> documentoList = new ArrayList<String>();
		for(Documento documento:Documento.values()) {
			documentoList.add(documento.name());
		}
		
		return documentoList;
	}
}
