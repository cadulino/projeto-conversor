package br.com.conversor.conversor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.conversor.conversor.dao.ConversorDao;
import br.com.conversor.conversor.models.ConversorModel;

@Controller
public class HomeController {
	
	@Autowired
	private ConversorDao dao;

	@GetMapping("/")
    public ModelAndView inicio(@ModelAttribute("conversor") ConversorModel conversor) {
        return new ModelAndView("home");
    }
	
	@PostMapping("/converter")
	public ModelAndView converter(@ModelAttribute("conversor") ConversorModel conversor, BindingResult result, RedirectAttributes attr) {
		if(conversor.getName().equals("EURO-IENE")) {
			ConversorModel conversorBd = dao.findByName("EURO-IENE").get(0);
			double euroToIene = conversor.getValor() * conversorBd.getValor();
	        return new ModelAndView("home", "euroToIene", euroToIene);
		}else {
			ConversorModel conversorBd = dao.findByName("IENE-EURO").get(0);
			double ieneToEuro = conversor.getValor() * conversorBd.getValor();
	        return new ModelAndView("home", "ieneToEuro", ieneToEuro);
		}
    }

}
