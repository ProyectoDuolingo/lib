package lib.duolingoproject.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
	
	@EmbeddedId
	@Column(name = "id")
	private LevelId id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "level_name")
	private String levelName;
	
	@OneToMany(mappedBy = "level")
	private List<Exercise> exercises;
	
	public Level(String levelName, Category category) {
		
		this.levelName = levelName;
		this.category = category;
		this.exercises = new ArrayList<Exercise>();
	}
	
	@Embeddable
	public class LevelId implements Serializable { // Implementamos serializable para definir una clave primaria compuesta entre una "id" que determinara el numero de nivel, y la id de la categoria a la que pertenezca el nivel.
		
		private static final long serialVersionUID = 1L;
		
		private Long levelId;
		private Long categoryId;
		
		public LevelId() {
			
		}
		
		public LevelId(long levelId, long categoryId) { 
			super();
			
			if (!(levelId >= 1 && levelId <= 5)) {
				return;
			}
			
			this.levelId = levelId;
			this.categoryId = categoryId;
			
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
	}

	public LevelId getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public String getLevelName() {
		return levelName;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setId(LevelId id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

}
