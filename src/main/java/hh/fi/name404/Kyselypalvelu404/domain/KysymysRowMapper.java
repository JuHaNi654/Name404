package hh.fi.name404.Kyselypalvelu404.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class KysymysRowMapper implements RowMapper<Kysymys> {
	
	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new Kysymys();
		kysymys.setId(rs.getLong("kysymysid"));
		kysymys.setTeksti(rs.getString("kysymys"));
		return kysymys;
	}

}
