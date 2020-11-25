package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("4")
@Table(name = "exercise_reorder_words")
public class ExerciseReorderWords extends Exercise {

	@Column(name = "phrase")//, unique = true)
	private String phrase;
	
	public ExerciseReorderWords() {
		super();
	}

	public ExerciseReorderWords(Level level, ExerciseType exerciseType, String phrase) {
		super(level, exerciseType);
		this.phrase = phrase;
	}
	
}
