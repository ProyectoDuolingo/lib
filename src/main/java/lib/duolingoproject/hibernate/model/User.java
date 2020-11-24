package lib.duolingoproject.hibernate.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long _id;
	
	@Column(name = "nickname")
	private String _nickname;
	
	@Column(name = "email")
	private String _email;
	
	@Column(name = "password")
	private String _password;
	
	@Column(name = "birthdate")
	private Date _birthdate;
	
	@Column(name = "avatar")
	private File _avatar;
	
	@Column(name = "genre")
	private String _genre;
	
	@Column(name = "register_date")
	private Date _registerDate;
	
	@Column(name = "xp_points")
	private int _xpPoints;
	
	@Column(name = "coins")
	private int _coins;
	
	@Column(name = "lifes")
	private int _lifes;
	
	@Column(name = "streak_days")
	private int _streakDays;
	
	private League _league;
	
	public User() {
		super();
		
	}
	
	public User(long _id, String _nickname, String _email, Date _birthdate, File _avatar, String _genre,
			Date _registerDate, int _xpPoints, int _coins, int _lifes, int _streakDays) {
		super();
		this._id = _id;
		this._nickname = _nickname;
		this._email = _email;
		this._birthdate = _birthdate;
		this._avatar = _avatar;
		this._genre = _genre;
		this._registerDate = _registerDate;
		this._xpPoints = _xpPoints;
		this._coins = _coins;
		this._lifes = _lifes;
		this._streakDays = _streakDays;
	}

	public long getId() {
		return _id;
	}
	public String getNickname() {
		return _nickname;
	}
	public String getEmail() {
		return _email;
	}
	public Date getBirthdate() {
		return _birthdate;
	}
	public File getAvatar() {
		return _avatar;
	}
	public String getGenre() {
		return _genre;
	}
	public Date getRegisterDate() {
		return _registerDate;
	}
	public int getXpPoints() {
		return _xpPoints;
	}
	public int getCoins() {
		return _coins;
	}
	public int getLifes() {
		return _lifes;
	}
	public int getStreakDays() {
		return _streakDays;
	}
	public void setId(long _id) {
		this._id = _id;
	}
	public void setNickname(String _nickname) {
		this._nickname = _nickname;
	}
	public void setEmail(String _email) {
		this._email = _email;
	}
	public void setBirthdate(Date _birthdate) {
		this._birthdate = _birthdate;
	}
	public void setAvatar(File _avatar) {
		this._avatar = _avatar;
	}
	public void setGenre(String _genre) {
		this._genre = _genre;
	}
	public void setRegisterDate(Date _registerDate) {
		this._registerDate = _registerDate;
	}
	public void setXpPoints(int _xpPoints) {
		this._xpPoints = _xpPoints;
	}
	public void setCoins(int _coins) {
		this._coins = _coins;
	}
	public void setLifes(int _lifes) {
		this._lifes = _lifes;
	}
	public void setStreakDays(int _streakDays) {
		this._streakDays = _streakDays;
	}
	
	

}
