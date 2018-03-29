package hh.fi.name404.Kyselypalvelu404.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.name404.Kyselypalvelu404.domain.Kysymys;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;

@Controller
public class KysymysController {
	@Autowired
	private KysymysRepository krepository;
	
	@GetMapping(value="/kysymykset")
	public @ResponseBody List<Kysymys> kysymysListRest() {
		return (List<Kysymys>) krepository.findAll();
	}
	@GetMapping(value="/kysymykset/{id}")
	public @ResponseBody Kysymys findKysymysRest(@PathVariable("id") Long id) {
		return krepository.findOne(id);
	}
	
}
