package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

public class ExerciseOpenTraduction extends Exercise {
	
	private String phrase;
	
	public ExerciseOpenTraduction() {
		super();
	}

	public ExerciseOpenTraduction(Level level, ExerciseType exerciseType, String phrase) {
		super(level, exerciseType);
		this.phrase = phrase;
	}	

}
