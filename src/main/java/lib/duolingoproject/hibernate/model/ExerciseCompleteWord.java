package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

public class ExerciseCompleteWord extends Exercise {

	private String phrase;
	
	private String word;
	
	public ExerciseCompleteWord() {
		super();
	}

	public ExerciseCompleteWord(Level level, ExerciseType exerciseType, String phrase, String word) {
		super(level, exerciseType);
		this.phrase = phrase;
		this.word = word;
	}	
	
	
}
