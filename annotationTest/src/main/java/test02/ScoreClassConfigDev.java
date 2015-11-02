package test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration 
@Profile("dev") 
public class ScoreClassConfigDev implements ScoreClassConfigProvider {

	@Bean
	public Score getScore() {
		return new Score("@Bean Dev", 100, 122, 211);
	}
}