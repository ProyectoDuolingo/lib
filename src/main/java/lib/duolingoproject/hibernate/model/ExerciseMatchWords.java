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

	public ExerciseMatchWords(Level level, ExerciseType exerciseType, String word1, String word2, String word3, String word4, String word5) {
		super(level, exerciseType);
		this.word1 = word1;
		this.word2 = word2;
		this.word3 = word3;
		this.word4 = word4;
		this.word5 = word5;
	}
	
	
}
