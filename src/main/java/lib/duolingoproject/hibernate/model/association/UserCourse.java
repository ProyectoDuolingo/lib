package lib.duolingoproject.hibernate.model.association;

import lib.duolingoproject.hibernate.model.Course;
import lib.duolingoproject.hibernate.model.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "user_course")
public class UserCourse { // Usamos esta clase para poder agregar columnas extras a una relacion "ManyToMany", como en este caso las coronas, el boolean de completado y los puntos de experiencia.
	
	@EmbeddedId
	private UserCourseId id = new UserCourseId();
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	@MapsId("userId")
	private User user;
	
	@ManyToOne(optional = false)
	@MapsId("courseId")
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name = "crowns")
	private int crowns;
	
	@Column(name = "is_completed")
	private boolean isCompleted;
	
	@Column(name = "xp_points")
	private int xpPoints;
	
	public UserCourse(User user, Course course) {
		
		this.user = user;
		this.course = course;
		this.crowns = 0;
		this.isCompleted = false;
		this.xpPoints = 0;
		
	}
	
	@Embeddable
	public class UserCourseId implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private Long userId;
		private Long courseId;
		
		public UserCourseId() {
			
		}
		
		public UserCourseId(long userId, long courseId) {
			super();
			this.userId = userId;
			this.courseId = courseId;
			
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
	
}

