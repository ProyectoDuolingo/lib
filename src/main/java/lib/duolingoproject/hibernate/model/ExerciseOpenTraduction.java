package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("3")
@Table(name = "exercise_open_traduction")
public class ExerciseOpenTraduction extends Exercise {
	
	@Column(name = "phrase")//, unique = true)
	private String phrase;
	
	public ExerciseOpenTraduction() {
		super();
	}

	public ExerciseOpenTraduction(Level level, ExerciseType exerciseType, String phrase) {
		super(level, exerciseType);
		this.phrase = phrase;
	}	

}
