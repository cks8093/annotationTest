package test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration 
@Profile("proc") 
public class ScoreClassConfigProc implements ScoreClassConfigProvider {

	@Bean
	public Score getScore() {
		return new Score("@Bean Proc", 100, 122, 211);
	}
}