package test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ScoreConfigParent {
	private ScoreClassConfigProvider scoreclassconfigprovider;

	@Bean
	public ScoreClassConfigProvider getScoreclassconfigprovider() {
		return scoreclassconfigprovider;
	}

	@Autowired
	public void setScoreclassconfigprovider(ScoreClassConfigProvider scoreclassconfigprovider) {
		this.scoreclassconfigprovider = scoreclassconfigprovider;
	}
}