package lib.duolingoproject.hibernate.model;

import lib.duolingoproject.hibernate.model.association.UserCourse;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nickname", unique = true)
	private String nickname;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "birth_date")
	private Date birthdate;
	
	@Column(name = "avatar")
	private File avatar;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "register_date")
	private Date registerDate;
	
	@Column(name = "xp_points")
	private int xpPoints;
	
	@Column(name = "coins")
	private int coins;
	
	@Column(name = "lifes")
	private int lifes;
	
	@Column(name = "streak_days")
	private int streakDays;
	
	@OneToMany(mappedBy = "course")
	private Set<UserCourse> userCourses; 
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "active_course_id")
	private Course activeCourse;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "league_id")
	private League league;
	
	@ManyToMany
	@JoinTable(
		name = "friends",
		joinColumns =  { @JoinColumn(name = "following_id") },
		inverseJoinColumns = { @JoinColumn(name = "follower_id") }
	)	
	private Set<User> followers;
	
	@ManyToMany
	@JoinTable(
			name = "friends",
			joinColumns =  { @JoinColumn(name = "follower_id") },
			inverseJoinColumns = { @JoinColumn(name = "following_id") }
		)	
	private Set<User> following;
	

	public User() {
		
	}
	
	public User(String nickname) {
		
		this.nickname = nickname;
		this.userCourses = new HashSet<UserCourse>();
		this.followers = new HashSet<User>();
		this.following = new HashSet<User>();
		
	}
	
	public void followUser(User followingUser) {
		
		this.following.add(followingUser);
		
		followingUser.followers.add(this);
		
	}
	
	public Set<User> getFollowers() {
		
		return this.followers;
		
	}
	
	public void addUserCourse(UserCourse userCourse) {
		
		this.userCourses.add(userCourse);
	
	}

}
