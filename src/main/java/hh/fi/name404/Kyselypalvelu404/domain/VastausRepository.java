package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	
	List<Vastaus> findAllByKysymysid(Long kysymysid);

}
