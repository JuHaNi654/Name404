package hh.fi.name404.Kyselypalvelu404.domain;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {

	Kysely findOne(Long kyselyid);
}
