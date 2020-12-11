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
	
}
