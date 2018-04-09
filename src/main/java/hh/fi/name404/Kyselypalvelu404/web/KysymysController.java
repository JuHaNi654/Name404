package hh.fi.name404.Kyselypalvelu404.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.name404.Kyselypalvelu404.domain.Kysymys;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Ryhma;
import hh.fi.name404.Kyselypalvelu404.domain.RyhmaRepository;

@Controller
public class KysymysController {
	@Autowired
	private KysymysRepository krepository;
	
	@Autowired
	private RyhmaRepository rrepository;
	
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
	
	// REST API DOKUMENTTI
	
	@RequestMapping(value="/index")
    public String restApiDokumentti() {	
        return "index";
    }
	
	@RequestMapping(value="/")
    public String restApiDokumenttiReD() {	
        return "redirect:/index";
    }
	
}
