package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
@Table(name = "exercise_complete_word")
public class ExerciseCompleteWord extends Exercise {

	@Column(name = "phrase")//, unique = true)
	private String phrase;
	
	@Column(name = "word")
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
