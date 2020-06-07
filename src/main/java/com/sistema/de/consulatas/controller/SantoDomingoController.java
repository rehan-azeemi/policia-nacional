package com.sistema.de.consulatas.controller;

import com.sistema.de.consulatas.config.URLConstants;
import com.sistema.de.consulatas.dto.SantoDomingoDto;
import com.sistema.de.consulatas.model.SantoDomingo;
import com.sistema.de.consulatas.services.SantoDomingoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
@RequestMapping("santo/domingo")
public class SantoDomingoController {
	
	@Autowired
	SantoDomingoService santoDomingoService;


    @Value("${file.path}")
    private String attachmentFileLocation;

    @Value("${image.path}")
    private String imageFileLocation;
	
	@GetMapping
	public ModelAndView getIndex() {
		SantoDomingo.srNo = 0;
		ModelAndView view = new ModelAndView("SantoDomingo");
		view.addObject("santoDomingo", new SantoDomingoDto());
		view.addObject("documento", santoDomingoService.getAllDocumento());
		
        view.addObject("santoDomingoList", santoDomingoService.findAll());
		
		return view;
	}

	@PostMapping(URLConstants.SAVE_URL)
	public String save(@ModelAttribute SantoDomingoDto santoDomingoDto) {
		santoDomingoService.save(santoDomingoDto,santoDomingoDto.getFoto(),santoDomingoDto.getAttachment());
		
		return "redirect:/santo/domingo";
	}

	@GetMapping(value = URLConstants.DELETE_URL)
	private String delete(@PathVariable Long id){
		santoDomingoService.delete(id);
		return "redirect:/santo/domingo";
	}
    @GetMapping(value = URLConstants.EDIT_URL)
    private ModelAndView edit(@PathVariable Long id){
    	SantoDomingo.srNo = 0;
        ModelAndView view = new ModelAndView("SantoDomingo");
        Map<String,String> fileMap = santoDomingoService.getFileNameById(id);
        view.addObject("santoDomingo",santoDomingoService.getDto(id));
        view.addObject("documento", santoDomingoService.getAllDocumento());
        if(fileMap.get("image")!=null)
        view.addObject("imageName","/"+imageFileLocation+fileMap.get("image"));
        if(fileMap.get("file")!=null)
        view.addObject("attachmentName","/"+attachmentFileLocation+fileMap.get("file"));
        view.addObject("santoDomingoList", santoDomingoService.findAll());
        return view;
    }

}
