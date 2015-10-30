package test01;

public class Score1 {
	String 	name;
	float		kor;
	float		eng;
	float		math;
	
	public Score1() { System.out.println("Score1 생성자 호출");}
	
	public Score1(String name, float kor, float eng, float math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		System.out.println("Score1 생성자 호출");
	}
	
	public float average() {
		return sum() / (float)3;
	}
	
	public float sum() {
		return kor + eng + math;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getKor() {
		return kor;
	}
	
	public void setKor(float kor) {
		this.kor = kor;
	}

	public float getEng() {
		return eng;
	}

	public void setEng(float eng) {
		this.eng = eng;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}
	
	public void initPool() {
		System.out.println("Score1.initPool()");
	}
	
	public void destroyPool() {
		System.out.println("Score1.destroyPool()");
	}

}