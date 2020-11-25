package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.ExerciseCompleteWord;

public interface IExerciseCompleteWordDao {

	public ExerciseCompleteWord getExerciseCompleteWordById(long id);
	public List<ExerciseCompleteWord> getAllExercisesCompleteWord();
	public void saveExerciseCompleteWord(ExerciseCompleteWord exerciseCompleteWord);
	public void updateExerciseCompleteWord(ExerciseCompleteWord exerciseCompleteWord);
	public void deleteExerciseCompleteWordById(long id);
	
}
