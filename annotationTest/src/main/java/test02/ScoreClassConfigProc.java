package test02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration 
@Profile("proc") 
public class ScoreClassConfigProc implements ScoreClassConfigProvider {
	
	@Bean
	public Score getScore() {		
		return new Score("@Bean Proc", 100, 122, 211);
	}
}