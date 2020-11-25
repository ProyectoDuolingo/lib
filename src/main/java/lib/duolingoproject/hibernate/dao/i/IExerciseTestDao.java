package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseTest;

public interface IExerciseTestDao {

	public ExerciseTest getExerciseTestById(long id);
	public List<ExerciseTest> getAllExercisesTest();
	public void saveExerciseTest(ExerciseTest exerciseTest);
	public void updateExerciseTest(ExerciseTest exerciseTest);
	public void deleteExerciseTestById(long id);
	
}
