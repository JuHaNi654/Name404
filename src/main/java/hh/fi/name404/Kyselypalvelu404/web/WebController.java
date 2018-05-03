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
import hh.fi.name404.Kyselypalvelu404.domain.Kysymys;
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
	
	@RequestMapping(value="/lisaa", method=RequestMethod.POST)
	public String uusiKysely(@ModelAttribute("kysely") Kysely kysely, @ModelAttribute("kysymyss") Kysymys kysymyss, Model model) {
		if(kysely.equals(null) ) {
			kysely=new Kysely();
			model.addAttribute("kysely", kysely);
			kysymyss=new Kysymys();
			kysymyss.setKysely(kysely);
			model.addAttribute("kysymyss", kysymyss);
			model.addAttribute("ryhmat", ryhmarepository.findAll());
			kyselyrepository.save(kysely);
			return "lisaakysely";
		} else {
			model.addAttribute("kysely", (kysely));
			kysymyss=new Kysymys();
			kysymyss.setKysely(kysely);
			model.addAttribute("kysymyss", kysymyss);
			return "lisaakysely";
		}
	}
	
	@RequestMapping(value="/tallenna", method=RequestMethod.POST)
	public String saveKysely(@ModelAttribute("kysely") Kysely kysely, Model model){
		kyselyrepository.save(kysely);
		return "redirect:/kaikkikyselyt";
	}
	
	@RequestMapping(value="/tallennakysymys/{kyselyid}", method=RequestMethod.POST)
	public String saveKysymys(@PathVariable("kyselyid") Long kyselyid, @ModelAttribute("kysymyss") Kysymys kysymyss, Model model, Kysely kysely){
		kysymysrepository.save(kysymyss);
		model.addAttribute("kysely", kyselyrepository.findOne(kyselyid));
		model.addAttribute("ryhmat", ryhmarepository.findAll());
		model.addAttribute("kysymykset", kysymysrepository.findByKysely(kysely=kyselyrepository.findOne(kyselyid)));
		kysymyss = new Kysymys();
		kysymyss.setKysely(kyselyrepository.findOne(kyselyid));
		model.addAttribute("kysymyss", kysymyss);
		return "muokkaakyselya";
	}
	
	@RequestMapping(value="/editkysely/{kyselyid}", method=RequestMethod.GET)
	public String editKysely(@PathVariable("kyselyid") Long kyselyid, Model model, @ModelAttribute("kysymyss") Kysymys kysymyss, Kysely kysely) {
		model.addAttribute("kysely", kyselyrepository.findOne(kyselyid));
		model.addAttribute("ryhmat", ryhmarepository.findAll());
		model.addAttribute("kysymykset", kysymysrepository.findByKysely(kysely=kyselyrepository.findOne(kyselyid)));
		return "muokkaakyselya";
	}
	
	@RequestMapping(value="/lisaakysymys/{kyselyid}", method=RequestMethod.GET)
	public String lisaaKysymys(@PathVariable("kyselyid") Long kyselyid, Model model, @ModelAttribute("kysymyss") Kysymys kysymyss) {
		kysymyss = new Kysymys();
		kysymyss.setKysely(kyselyrepository.findOne(kyselyid));
		model.addAttribute("kysymyss", kysymyss);
	return "/lisaakysymys";
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