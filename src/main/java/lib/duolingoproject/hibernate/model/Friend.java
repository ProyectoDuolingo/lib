package lib.duolingoproject.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friend")
public class Friend {
	
	private User _follower;
	
	private User _following;

}
