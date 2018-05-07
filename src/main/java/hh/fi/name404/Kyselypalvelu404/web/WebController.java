package hh.fi.name404.Kyselypalvelu404.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hh.fi.name404.Kyselypalvelu404.domain.Kysely;
import hh.fi.name404.Kyselypalvelu404.domain.KyselyRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Kysymys;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.RyhmaRepository;
import hh.fi.name404.Kyselypalvelu404.domain.Vaihtoehto;
import hh.fi.name404.Kyselypalvelu404.domain.VaihtoehtoRepository;

@Controller
public class WebController {

	@Autowired
	private KyselyRepository kyselyrepository;

	@Autowired
	private KysymysRepository kysymysrepository;

	@Autowired
	private RyhmaRepository ryhmarepository;

	@Autowired
	private VaihtoehtoRepository vaihtoehtorepository;

	@RequestMapping(value="/kaikkikyselyt", method=RequestMethod.GET)
	public String kyselytListattuna(Model model) {
		model.addAttribute("kyselyt", kyselyrepository.findAll());
		return "/kaikkikyselyt";
	}
	// Lisää kysely
	@RequestMapping(value="/lisaa", method=RequestMethod.GET)
	public String uusiKysely(Kysely kysely,  Model model) {
		model.addAttribute("kysely", (kysely));
		model.addAttribute("ryhmat", ryhmarepository.findAll());
		return "lisaakysely";
	}
	// Tallenna kysely (Post)
	@RequestMapping(value="/tallenna", method=RequestMethod.POST)
	public String saveKysely(@ModelAttribute("kysely") Kysely kysely){
		kyselyrepository.save(kysely);
		return "redirect:/editkysely/" + kysely.getKyselyid();
	}

	// Muokkaa kyselyä (Get)
	@RequestMapping(value="/editkysely/{kyselyid}", method=RequestMethod.GET)
	public String editKysely(@PathVariable("kyselyid") Long kyselyid, Model model, @ModelAttribute("kysymyss") Kysymys kysymyss, Kysely kysely) {
		model.addAttribute("kysely", kyselyrepository.findOne(kyselyid));
		model.addAttribute("ryhmat", ryhmarepository.findAll());
		model.addAttribute("kysymykset", kysymysrepository.findByKysely(kysely=kyselyrepository.findOne(kyselyid)));
		return "muokkaakyselya";
	}
	// Lisää kysymys kyselyyn (Get)
	@RequestMapping(value="/lisaakysymys/{kyselyid}", method=RequestMethod.GET)
	public String lisaaKysymys(@PathVariable("kyselyid") Long kyselyid, Model model, @ModelAttribute("kysymyss") Kysymys kysymyss) {
		kysymyss = new Kysymys();
		List<String> vaihtoehdot = new ArrayList<String>();
		kysymyss.setKysely(kyselyrepository.findOne(kyselyid));
		model.addAttribute("kysymyss", kysymyss);
		model.addAttribute("vaihtoehdot", vaihtoehdot);
		return "lisaakysymys";
	}
	
	// Tallenna kysymys (Post)
	@RequestMapping(value="/tallennakysymys/{kyselyid}", method=RequestMethod.POST)
	public String saveKysymys(@PathVariable("kyselyid") Long kyselyid, @ModelAttribute("kysymyss") Kysymys kysymyss, Model model, Kysely kysely, List<String> vaihtoehdot){
		for (int i = 0; vaihtoehdot.size()>=i; ++i) {
			Vaihtoehto vaihtoehtoloop = new Vaihtoehto();
			vaihtoehtoloop.setVaihtoehto(vaihtoehdot.get(i));
			vaihtoehtoloop.setKysymys(kysymyss);
			vaihtoehtorepository.save(vaihtoehtoloop);
		}
		kysymysrepository.save(kysymyss);
		System.out.println(kysymyss);
		return "redirect:/editkysely/{kyselyid}";
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