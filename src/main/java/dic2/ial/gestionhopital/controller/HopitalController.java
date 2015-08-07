package dic2.ial.gestionhopital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dic2.ial.gestionhopital.services.IHopitalServices;

@Controller  
public class HopitalController {
	@Autowired
	private IHopitalServices services;
	
	@RequestMapping(value = "/")
	public String slash(){
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index(){
		return "index";
	}
	@RequestMapping(value = "/accueil")
	public String accueil(){
		return "accueil";
	}
}
