package test02;

import org.springframework.beans.factory.annotation.Autowired;

public class ScoreParent {
	private Score 	score;

	public Score getScore() {
		return score;
	}

	@Autowired
	public void setScore(Score score) {
		System.out.println("@Autowired Score");
		this.score = score;
	}
}