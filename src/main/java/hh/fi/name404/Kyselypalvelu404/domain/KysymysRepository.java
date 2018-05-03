package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepository extends CrudRepository<Kysymys, Long> {

	Kysymys findOne(Long kysymysid);

	List<Kysymys> findByKysely(Kysely kysely);
	
}
