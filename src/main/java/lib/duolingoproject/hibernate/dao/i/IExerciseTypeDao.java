package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseType;

public interface IExerciseTypeDao {

	public ExerciseType getExerciseTypeById(long id);
	public List<ExerciseType> getAllExercisesType();
	public void saveExerciseType(ExerciseType exerciseType);
	public void updateExerciseType(ExerciseType exerciseType);
	public void deleteExerciseTypeById(long id);
	
}
