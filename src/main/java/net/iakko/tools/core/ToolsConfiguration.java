package net.iakko.tools.core;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ToolsConfiguration
{
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "tools.datasource.mysql")
	public DataSource mysqlDataSource()
	{
		return DataSourceBuilder.create().build();
	}
}
