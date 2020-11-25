package lib.duolingoproject.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "division")
public class Division {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "division_name")
	private String divisionName;
	
	@OneToMany(mappedBy = "division")
	private List<League> leagues;
	
	public Division() {
		
	}
	
	public Division(String divisionName) {
		
		this.divisionName = divisionName;
		this.leagues = new ArrayList<League>();
		
	}

	public Division(long id, String divisionName, List<League> leagues) {
		super();
		this.id = id;
		this.divisionName = divisionName;
		this.leagues = leagues;
	}
	
	public void addLeague(League league) {
		
		this.leagues.add(league);
		
	}
	
}
