package lib.duolingoproject.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "league")
public class League {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "division_id")
	private Division division;
	
	@OneToMany(mappedBy = "league")
	private List<User> players;
	
	public void addPlayer(User player) {
		
		this.players.add(player);
		
	}

}
