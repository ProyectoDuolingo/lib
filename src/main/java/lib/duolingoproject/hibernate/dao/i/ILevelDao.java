package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Level;

public interface ILevelDao {

	public Level getLevelById(long id);
	public List<Level> getAllLevelsByCategoryId(long id);
	public void saveLevel(Level level);
	public void updateLevel(Level level);
	public void deleteLevelById(long id);
}
