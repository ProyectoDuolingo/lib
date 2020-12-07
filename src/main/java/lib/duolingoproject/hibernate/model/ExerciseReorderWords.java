package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

public class ExerciseReorderWords extends Exercise {

	private String phrase;
	
	public ExerciseReorderWords() {
		super();
	}

	public ExerciseReorderWords(Level level, ExerciseType exerciseType, String phrase) {
		super(level, exerciseType);
		this.phrase = phrase;
	}
	
}
