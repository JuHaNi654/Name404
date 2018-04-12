package hh.fi.name404.Kyselypalvelu404.domain;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	
	Vastaus findOne(Long vastausid);

}
