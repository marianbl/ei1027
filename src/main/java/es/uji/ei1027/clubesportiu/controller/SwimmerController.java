
package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.SwimmerDao;
import es.uji.ei1027.clubesportiu.model.Swimmer;


@Controller
@RequestMapping("/swimmer") 
public class SwimmerController {

	private SwimmerDao swimmerDao; 

	@Autowired
	public void setSwimmerDao(SwimmerDao swimmerDao)  {
		this.swimmerDao=swimmerDao;
	}

	// Operations: Create, list, update, delete
	// ...
	

	@RequestMapping("/list") 
	public String listSwimmers(Model model) {
		model.addAttribute("swimmers", swimmerDao.getSwimmers());
		return "swimmer/list";
	}

	@RequestMapping(value="/add") 
	public String addSwimmer(Model model) {
		model.addAttribute("swimmer", new Swimmer());
		return "swimmer/add";
	}


	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit (@ModelAttribute("swimmer") Swimmer swimmer, 
	BindingResult bindingResult) {  
		if (bindingResult.hasErrors()) 
			return "swimmer/add";
		swimmerDao.addSwimmer(swimmer);
	 	return "redirect:list.html"; 
	}
	
	@RequestMapping(value="/update/{name}", method = RequestMethod.GET) 
	public String editSwimmer(Model model, @PathVariable String name)  { 
		model.addAttribute("swimmer", swimmerDao.getSwimmer(name));
		return "swimmer/update"; 
	}

	@RequestMapping(value="/update/{name}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable String name, 
				 @ModelAttribute("swimmer") Swimmer swimmer, 
				 BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "swimmer/update";
		 swimmerDao.updateSwimmer(swimmer);
		 return "redirect:../list"; 
	}
	

	@RequestMapping(value="/delete/{name}")
	public String processDelete (@PathVariable String name) {
           swimmerDao.deleteSwimmer(name);
           return "redirect:../list"; 
	}


}


