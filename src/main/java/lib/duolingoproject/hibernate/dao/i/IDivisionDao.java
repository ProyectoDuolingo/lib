package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Division;

public interface IDivisionDao {

	public Division getDivisionById(long id);
	public List<Division> getAllDivisions();
	public void saveDivision(Division division);
	public void updateDivision(Division division);
	public void deleteDivisionById(long id);
	
}
