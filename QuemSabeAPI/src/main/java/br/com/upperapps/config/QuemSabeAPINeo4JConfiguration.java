package br.com.upperapps.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("br.com.upperapps")
@EnableNeo4jRepositories("br.com.upperapps.repository")
public class QuemSabeAPINeo4JConfiguration extends Neo4jConfiguration{

	public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "http://neo4j:graph@localhost:7474";

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
    	
    	final String username = "neo4j";
    	final String password = "fab014";
    	
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        
        config.driverConfiguration()
        	.setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
        	.setURI(URL)
        	.setCredentials(username, password);
        return config;
    }
	
	@Override
	public SessionFactory getSessionFactory() {
		return new SessionFactory(getConfiguration(), "br.com.upperapps.domain");
	}

}
