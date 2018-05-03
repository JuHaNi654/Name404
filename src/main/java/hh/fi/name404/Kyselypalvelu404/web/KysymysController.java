package hh.fi.name404.Kyselypalvelu404.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.fi.name404.Kyselypalvelu404.domain.Kysymys;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Ryhma;
import hh.fi.name404.Kyselypalvelu404.domain.RyhmaRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Vastaus;
import hh.fi.name404.Kyselypalvelu404.domain.VastausRepository;
@RestController
@CrossOrigin
public class KysymysController {
	@Autowired
	private KysymysRepository krepository;
	
	@Autowired
	private RyhmaRepository rrepository;
	
	@Autowired
	private VastausRepository vrepository;
	
	
	
	@GetMapping(value="/kysymykset")
	public @ResponseBody List<Kysymys> kysymysListRest() {
		return (List<Kysymys>) krepository.findAll();
	}
	
	@GetMapping(value="/kysymykset/{id}")
	public @ResponseBody Kysymys findKysymysRest(@PathVariable("id") Long id) {
		return krepository.findOne(id);
	}
	
	@GetMapping(value="/ryhmat")
	public @ResponseBody List<Ryhma> ryhmaListRest() {
		return (List<Ryhma>) rrepository.findAll();
	}
	
	@GetMapping(value="/ryhmat/{id}")
	public @ResponseBody Ryhma findRyhmaRest(@PathVariable("id") Long ryhmaid) {
		return rrepository.findOne(ryhmaid);
	}
	
	@GetMapping(value="/kysymykset/{id}/vastaukset")
	public @ResponseBody List<Vastaus> kysymyksenVastauksetRest(@PathVariable("id") Kysymys kysymys) {
		List<Vastaus> vastaukset = vrepository.findAllByKysymys(kysymys);
		return vastaukset;
	}
	
}
