package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;

//@MappedSuperclass
@Entity
public abstract class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
			
	@MapsId("level_id")
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "level_id"),
		@JoinColumn(name = "category_id")
	})
	private Level level;
	
	@ManyToOne
	@JoinColumn(name = "exercise_type_id")
	private ExerciseType exerciseType;
	
	public Exercise() {
		
	}	

	public Exercise(Level level, ExerciseType exerciseType) {
		
		this.level = level;
		this.exerciseType = exerciseType;
	}
	

}
