package rk.interview.appone;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppOneApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "app-one.datasource")
	public DataSource dataSource() {
		return new BasicDataSource();

	}
	
	@Bean(initMethod = "migrate")
	public Flyway flyway(DataSource dataSource)
	{
		FluentConfiguration configure = Flyway.configure();
		configure.baselineOnMigrate(true);
		configure.dataSource(dataSource);
		configure.locations("classpath:db/migration/schema");
		return configure.load();
	}

	@Bean
	public FlywayMigrationInitializer flywayInitializer(Flyway flyway)
	{
		return new FlywayMigrationInitializer(flyway, null);
	}
}
