package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

public class ExerciseTest extends Exercise {

	private String question;
	private String option1;
	private String option2;
	private String option3;
	
	public ExerciseTest() {
		super();
	}

	public ExerciseTest(Level level, ExerciseType exerciseType, String question, String option1, String option2, String option3) {
		super(level, exerciseType);
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}	
	
}
