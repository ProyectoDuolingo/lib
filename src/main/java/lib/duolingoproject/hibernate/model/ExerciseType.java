package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise_type")
public class ExerciseType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "exercise_name", unique = true)
	private String exerciseName;
	
	@Column(name = "xp_points")
	private int xpPoints;
	
	public ExerciseType(int id, String exerciseName, int xpPoints) {
		this.id = id;
		this.exerciseName = exerciseName;
		this.xpPoints = xpPoints;
	}

	public ExerciseType(String exerciseName) {
		
		this.exerciseName = exerciseName;
	}	
	
	

}
