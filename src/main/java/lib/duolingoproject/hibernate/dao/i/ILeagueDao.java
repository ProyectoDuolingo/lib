package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.League;

public interface ILeagueDao {

	public League getLeagueById(long id);
	public List<League> getAllLeagues();
	public void saveLeague(League league);
	public void updateLeague(League league);
	public void deleteLeagueById(long id);
}
