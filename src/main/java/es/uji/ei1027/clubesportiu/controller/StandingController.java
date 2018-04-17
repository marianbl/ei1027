package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.services.ClassificationService;

public class StandingController {
	private ClassificationService classificationService;

	@Autowired
	public void setClassificationService(
                                   ClassificationService classificationService) {
		this.classificationService = classificationService;
	}

	@RequestMapping("/bycountry")
	public String listClsfByCountry(Model model) {
		model.addAttribute("standings", 
                classificationService.getClassificationByCountry("Synchro Duet"));
		return "standing/bycountry";
	}

}
