package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseMatchWords;

public interface IExerciseMatchWordsDao {

	public ExerciseMatchWords getExerciseMatchWordsById(long id);
	public List<ExerciseMatchWords> getAllExercisesMatchWords();
	public void saveExerciseMatchWords(ExerciseMatchWords exerciseMatchWords);
	public void updateExerciseMatchWords(ExerciseMatchWords exerciseMatchWords);
	public void deleteExerciseMatchWordsById(long id);
	
}
