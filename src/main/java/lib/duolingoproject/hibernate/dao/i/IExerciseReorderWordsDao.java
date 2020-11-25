package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseReorderWords;

public interface IExerciseReorderWordsDao {

	public ExerciseReorderWords getExerciseReorderWordsById(long id);
	public List<ExerciseReorderWords> getAllExercisesReorderWords();
	public void saveExerciseReorderWords(ExerciseReorderWords exerciseReorderWords);
	public void updateExerciseReorderWords(ExerciseReorderWords exerciseReorderWords);
	public void deleteExerciseReorderWordsById(long id);
	
}
