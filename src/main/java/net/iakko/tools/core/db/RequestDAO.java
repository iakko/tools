package net.iakko.tools.core.db;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void trace(String ip, Integer port, String source)
	{
		String sql = "INSERT INTO request (ip, port, date) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { ip, port, new Date(), source });
	}
}
