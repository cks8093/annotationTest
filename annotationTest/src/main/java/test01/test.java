package test01;



import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("/test01/beans.xml");
		
		Score score = (Score)ctx.getBean("score");
		Score1 score1 = (Score1)ctx.getBean("score1");
		
		ctx.close();
		
		System.out.println("컨텍스트 해제");
	}
}
