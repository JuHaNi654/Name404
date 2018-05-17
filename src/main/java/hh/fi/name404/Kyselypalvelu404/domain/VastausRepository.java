package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VastausRepository extends CrudRepository<Vastaus, Long> {
	
	List<Vastaus> findAllByKysymys(Kysymys kysymys);
	
	@Query(value = "SELECT * FROM vastaus LEFT JOIN kysymys ON kysymys.kysymysid = vastaus.kysymysid LEFT JOIN kysely ON kysymys.kyselyid = kysely.kyselyid WHERE kysely.kyselyid = ?;", nativeQuery = true)
	List<Vastaus> findByKysely(Long kyselyid);

}
