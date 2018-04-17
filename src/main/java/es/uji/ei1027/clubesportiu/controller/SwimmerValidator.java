package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.Swimmer;

public class SwimmerValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return Swimmer.class.equals(cls);
	 // Or if we wanted to try also subclasses: 
	 // Return Nadador.class.isAssignableFrom(cls);
  }
 
  @Override
  public void validate(Object obj, Errors errors) {
	 Swimmer swimmer = (Swimmer)obj;
	 if (swimmer.getName().trim().equals(""))
	       errors.rejectValue("name", "obligatory",
	                          "You must enter a value");
	 // Add the validation here for Age > 15 years	
	 if(swimmer.getAge() < 15){
		 errors.rejectValue("age", "must be over than 15");
	 }
  }
}

