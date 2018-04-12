package hh.fi.name404.Kyselypalvelu404.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Vastaus;
import hh.fi.name404.Kyselypalvelu404.domain.VastausRepository;

@Controller
public class VastausController {
	@Autowired
	private VastausRepository vrepository;
	
	@RequestMapping(value = "/addvastaus", method = RequestMethod.POST)
    public @ResponseBody Vastaus addVastaus(@RequestBody Vastaus vastaus){
		System.out.println("Olio" +  vastaus);
        vrepository.save(vastaus);
        return vastaus;
    }

}
