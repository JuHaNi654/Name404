package hh.fi.name404.Kyselypalvelu404.domain;

import org.springframework.data.repository.CrudRepository;

public interface RyhmaRepository extends CrudRepository<Ryhma, Long> {

	Ryhma findOne(Long ryhmaid);
	
}