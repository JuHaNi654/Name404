package hh.fi.name404.Kyselypalvelu404.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.fi.name404.Kyselypalvelu404.domain.Vastaus;
import hh.fi.name404.Kyselypalvelu404.domain.VastausRepository;

@Controller
public class VastausController {
	@Autowired
	private VastausRepository vrepository;
	
	@RequestMapping(value = "/addvastaus", method = RequestMethod.POST)
    public String addVastaus(Vastaus vastaus){
        vrepository.save(vastaus);
        return "redirect:/";
    }

}
