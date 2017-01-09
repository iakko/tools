package net.iakko.tools.core;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import({CustomConfig.class})
public class ToolsConfiguration
{
	@Autowired
	CustomConfig c3p0Configuration;
	
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
	
	@Bean
	@Primary
	public DataSource mysqlDataSource() throws PropertyVetoException
	{
		return c3p0Configuration.dataSource();
	}
}
