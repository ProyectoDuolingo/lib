package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

public class ExerciseMatchWords extends Exercise {

	private String word1;
	
	private String word2;
	
	private String word3;
	
	private String word4;
	
	private String word5;
	
	public ExerciseMatchWords() {
		super();
	}	
	
}
