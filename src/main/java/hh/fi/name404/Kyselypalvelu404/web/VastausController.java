package hh.fi.name404.Kyselypalvelu404.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Vastaus;
import hh.fi.name404.Kyselypalvelu404.domain.VastausRepository;

@RestController
@CrossOrigin
public class VastausController {
	@Autowired
	private VastausRepository vrepository;
	
	@RequestMapping(value = "/addvastaus", method = RequestMethod.POST)
    public @ResponseBody Vastaus addVastaus(@RequestBody Vastaus vastaus){
		System.out.println("Olio" +  vastaus);
        vrepository.save(vastaus);
        return vastaus;
    }
	
	@GetMapping(value="/kyselyt/{id}/vastaukset")
	public @ResponseBody  List<Vastaus> findByKysely(@PathVariable("id") Long kyselyid) {
		List<Vastaus> vastaukset = vrepository.findByKysely(kyselyid);
		return vastaukset;
	}

}
