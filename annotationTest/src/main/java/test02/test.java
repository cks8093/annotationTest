package test02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;

public class test {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	private static void test3() {
		// TODO Auto-generated method stub
		System.out.println("===== @Configuration profile을 이용한 설정 ==== ");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigByPropSource.class);

		ConfigurableEnvironment env = ctx.getEnvironment();
		String javaVersion = env.getProperty("java.version");
		String dbUser = env.getProperty("db.user");

		System.out.printf("java version is %s\n", javaVersion);
		System.out.printf("dbUser is %s\n", dbUser);
		
		JdbcConnectionProvider JdbcConnectionProvider = ctx.getBean(JdbcConnectionProvider.class);
		System.out.printf("getUrl %s\n", JdbcConnectionProvider.getUrl());		
	}

	private static void test2() {
		// TODO Auto-generated method stub
		System.out.println("===== @PropertySource ==== ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("proc");
		context.register(ScoreClassConfigDev.class, ScoreClassConfigProc.class, ScoreConfigParent.class);
		context.refresh();

		ScoreConfigParent scoreconfigparent = context.getBean(ScoreConfigParent.class);

		System.out.println(scoreconfigparent.getScoreclassconfigprovider().getScore().name);

		/*
		 * context.getEnvironment().setActiveProfiles("proc");
		 * context.refresh(); scoreconfigparent =
		 * context.getBean(ScoreConfigParent.class);
		 * 
		 * System.out.println(scoreconfigparent.getScoreclassconfigprovider().
		 * getScore().name);
		 */

		context.close();
	}

	private static void test1() {
		// TODO Auto-generated method stub
		System.out.println("===== <beans> profile을 이용한 설정 ==== ");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/test02/beans.xml");
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.refresh();

		ScoreParent scoreparent = (ScoreParent) ctx.getBean("scoreparent");

		System.out.println(scoreparent.getScore().name);

		ctx.getEnvironment().setActiveProfiles("proc");
		ctx.refresh();
		scoreparent = (ScoreParent) ctx.getBean("scoreparent");

		System.out.println(scoreparent.getScore().name);

		ctx.close();
	}
}
