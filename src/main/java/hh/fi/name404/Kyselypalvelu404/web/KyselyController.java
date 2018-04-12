package hh.fi.name404.Kyselypalvelu404.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.name404.Kyselypalvelu404.domain.Kysely;
import hh.fi.name404.Kyselypalvelu404.domain.KyselyRepository;
import hh.fi.name404.Kyselypalvelu404.domain.KysymysRepository;
import hh.fi.name404.Kyselypalvelu404.domain.RyhmaRepository;

@Controller
public class KyselyController {
	@Autowired KyselyRepository krepository;
	@Autowired KysymysRepository kyrepository;
	
	@GetMapping(value="/kyselyt")
	public @ResponseBody List<Kysely> kyselyListRest() {
		return (List<Kysely>) krepository.findAll();
	}
	@GetMapping(value="/kyselyt/{id}")
	public @ResponseBody  Kysely findKyselyRest(@PathVariable("id") Long kyselyid) {
		return krepository.findOne(kyselyid);
	}
	
}
