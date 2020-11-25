package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseOpenTraduction;

public interface IExerciseOpenTraductionDao {

	public ExerciseOpenTraduction getExerciseOpenTraductionById(long id);
	public List<ExerciseOpenTraduction> getAllExercisesOpenTraduction();
	public void saveExerciseOpenTraduction(ExerciseOpenTraduction exerciseOpenTraduction);
	public void updateExerciseOpenTraduction(ExerciseOpenTraduction exerciseOpenTraduction);
	public void deleteExerciseOpenTraductionById(long id);
	
}
