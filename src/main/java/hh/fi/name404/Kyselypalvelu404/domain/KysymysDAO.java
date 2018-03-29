package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class KysymysDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/// Hae kysymys id:n perusteella
	public Kysymys findOne(Long id) {
		String sql = "select * from kyselynkysymykset where id = ?;";
		Object[] parameters = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		Kysymys kysymys = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return kysymys;
	}

	/// Hae kaikki
	public List<Kysymys> findAll() {
		String sql = "SELECT * FROM kyselynkysymykset ORDER BY id";
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, mapper);
		return kysymykset;
	}

}
