package test02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		test1();
		//test2();
	}

	private static void test2() {
		System.out.println("===== @Configuration profile을 이용한 설정 ==== ");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(ScoreClassConfigDev.class, ScoreClassConfigProc.class, ScoreConfigParent.class);
		context.refresh();
		
		ScoreConfigParent scoreconfigparent = context.getBean(ScoreConfigParent.class);
		
		System.out.println(scoreconfigparent.getScoreclassconfigprovider().getScore().name);
		
		/*context.getEnvironment().setActiveProfiles("proc");
		context.refresh();
		scoreconfigparent = context.getBean(ScoreConfigParent.class);
		
		System.out.println(scoreconfigparent.getScoreclassconfigprovider().getScore().name);*/
		
		context.close();
	}

	private static void test1() {
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
