package test02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Score {
	String 	name;
	float		kor;
	float		eng;
	float		math;
	
	public Score() {}
	
	public Score(String name, float kor, float eng, float math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		
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
	
	/*- 의존하는 객체를 설정한 이후에 초기화 작업을 수행할 메서드에 적용
	  - init-method 속성과 같음*/
	@PostConstruct
	public void initPool() {
		
	}

	/*- 컨테이너에서 객체를 제거하기 전에 호출 될 메서드에 적용
	  - destroy-method 속성과 같음*/
	@PreDestroy
	public void destroyPool() {
		
	}

}