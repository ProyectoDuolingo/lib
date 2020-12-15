package lib.duolingoproject.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

//	@MapsId("category_id")
//	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name = "category_id"),
//		@JoinColumn(name = "course_id")
//	})
//	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "level_name")
	private String levelName;
	
	@OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
	private List<Exercise> exercises;
	
	public Level(String levelName, Category category) {
		
		this.levelName = levelName;
		this.category = category;
		this.exercises = new ArrayList<Exercise>();
	}
	
	public Level() {
		
	}
	
	@Embeddable
	public class LevelId implements Serializable {
		
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
	
	public long getId() {
		return id;
	}

//	public LevelId getId() {
//		return id;
//	}

	public Category getCategory() {
		return category;
	}

	public String getLevelName() {
		return levelName;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

//	public void setId(LevelId id) {
//		this.id = id;
//	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	public String toString() {
		
		return levelName;
		
	}

}
