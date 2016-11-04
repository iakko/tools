package net.iakko.tools.core.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.iakko.tools.core.db.data.User;

@Repository
public class UserDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(User usr)
	{
		String sql = "INSERT INTO user (first_name, last_name) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { usr.getFirstName(), usr.getLastName() });
	}

	public void init()
	{
		String sql = "CREATE TABLE USER (USR_ID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,EMAIL VARCHAR(30) NOT NULL,PHONE VARCHAR(15) NOT NULL)";
		jdbcTemplate.execute(sql);
	}
}
