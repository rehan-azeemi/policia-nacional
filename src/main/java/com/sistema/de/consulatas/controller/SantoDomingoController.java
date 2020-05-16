package com.sistema.de.consulatas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sistema.de.consulatas.config.*;
import com.sistema.de.consulatas.model.SantoDomingo;
import com.sistema.de.consulatas.services.SantoDomingoService;


@Controller
@RequestMapping("santo/domingo")
public class SantoDomingoController {
	
	@Autowired
	SantoDomingoService santoDomingoService;
	
	@GetMapping
	public ModelAndView getIndex() {
		ModelAndView view = new ModelAndView("SantoDomingo");
		view.addObject("santoDomingo", new SantoDomingo());
		view.addObject("documento", santoDomingoService.getAllDocumento());
		
		return view;
	}

	@PostMapping(URLConstants.SAVE_URL)
	public ModelAndView save() {
		ModelAndView view = new ModelAndView("SantoDomingo");
		view.addObject("santoDomingo", new SantoDomingo());
		view.addObject("documento", santoDomingoService.getAllDocumento());
		
		return view;
	}
}
