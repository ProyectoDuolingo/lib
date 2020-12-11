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
	
}
