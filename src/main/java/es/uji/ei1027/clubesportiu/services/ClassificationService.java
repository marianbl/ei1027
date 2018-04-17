package es.uji.ei1027.clubesportiu.services;

import es.uji.ei1027.clubesportiu.model.Swimmer;
import java.util.Map;
import java.util.List;

public interface ClassificationService{
	
	public Map<String, List<Swimmer>> getClassificationByCountry(String event);

}


