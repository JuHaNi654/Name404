package hh.fi.name404.Kyselypalvelu404.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.fi.name404.Kyselypalvelu404.domain.Kysely;
import hh.fi.name404.Kyselypalvelu404.domain.KyselyRepository;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.RyhmaRepository;

@Controller
public class WebController {
	
	@Autowired
	private KyselyRepository kyselyrepository;
	
	@Autowired
	private KysymysRepository kysymysrepository;
	
	@Autowired
	private RyhmaRepository ryhmarepository;
	
	@RequestMapping(value="/kaikkikyselyt", method=RequestMethod.GET)
	public String kyselytListattuna(Model model) {
		model.addAttribute("kyselyt", kyselyrepository.findAll());
		return "/kaikkikyselyt";
	}
	
	@RequestMapping(value="/lisaa")
	public String uusiKysely(Model model) {
		model.addAttribute("kysely", new Kysely());
		model.addAttribute("kysymys", kysymysrepository.findAll());
		model.addAttribute("ryhma", ryhmarepository.findAll());
		return "lisaakysely";
	}
	
	@RequestMapping(value="/tallenna", method=RequestMethod.POST)
	public String saveMovie(@ModelAttribute("kysely") Kysely kysely, Model model){
		kyselyrepository.save(kysely);
		return "redirect:/kaikkikyselyt";
	}
	
	@RequestMapping(value="/editkysely/{kyselyid}", method=RequestMethod.GET)
	public String editKysely(@PathVariable("kyselyid") Long kyselyid, Model model) {
		model.addAttribute("kysely", kyselyrepository.findOne(kyselyid));
		model.addAttribute("kysymys", kysymysrepository.findAll());
		model.addAttribute("ryhma", ryhmarepository.findAll());
		return "muokkaakyselya";
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