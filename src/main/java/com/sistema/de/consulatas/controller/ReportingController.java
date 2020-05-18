package com.sistema.de.consulatas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.de.consulatas.config.URLConstants;
import com.sistema.de.consulatas.dto.SantoDomingoDto;
import com.sistema.de.consulatas.model.SantoDomingoReport;
import com.sistema.de.consulatas.repository.SantoDomingoRepo;
import com.sistema.de.consulatas.services.ReportingService;

@Controller
@RequestMapping("santo/domingo/report")
public class ReportingController {
	
	@Autowired
	private ReportingService reportingService;
	
	@GetMapping
	public ModelAndView getIndex() {
		ModelAndView view = new ModelAndView("report");
		view.addObject("santoDomingoReport", new SantoDomingoReport());
		
		return view;
	}
	
	@PostMapping(URLConstants.PRINT)
	public String printReport(@ModelAttribute SantoDomingoReport santoDomingoReport) {
		reportingService.printReport(santoDomingoReport);
		return "redirect:/santo/domingo/report";
	}

}
