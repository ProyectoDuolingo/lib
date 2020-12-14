package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Exercise;

public interface IExerciseDao {

	public List<Exercise> getExercisesByLevelIdAndTypeId(long idLevel, long idType);
	public List<Exercise> getAllExercisesByLevelId(long idLevel);
	public void saveExercise(Exercise exercise);
	public void updateExercise(Exercise exercise);
	public void deleteExerciseById(long id);
	
}
