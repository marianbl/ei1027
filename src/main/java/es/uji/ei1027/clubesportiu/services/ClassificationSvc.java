
package es.uji.ei1027.clubesportiu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.clubesportiu.dao.StandingDao;
import es.uji.ei1027.clubesportiu.dao.SwimmerDao;
import es.uji.ei1027.clubesportiu.model.Standing;
import es.uji.ei1027.clubesportiu.model.Swimmer;

@Service
public class ClassificationSvc implements ClassificationService {

	@Autowired
	SwimmerDao swimmerDao;

	@Autowired
	StandingDao standingDao;

	@Override
	public Map<String, List<Swimmer>> getClassificationByCountry(String event) {
		List<Standing> standEvent = standingDao.getStandingEvent(event);
		HashMap<String,List<Swimmer>> swimmersByCountry = 
                                 new HashMap<String,List<Swimmer>>();
		for (Standing clsf : standEvent) {
			Swimmer swimmer = swimmerDao.getSwimmer(clsf.getSwimmerName());
			if (!swimmersByCountry.containsKey(swimmer.getCountry()))
				swimmersByCountry.put(swimmer.getCountry(), 
                                               new ArrayList<Swimmer>());
			swimmersByCountry.get(swimmer.getCountry()).add(swimmer);
		}
		return swimmersByCountry;
	}
}
