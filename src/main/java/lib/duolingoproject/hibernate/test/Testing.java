package lib.duolingoproject.hibernate.test;

import lib.duolingoproject.hibernate.dao.*;
import lib.duolingoproject.hibernate.dao.i.*;
import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.model.association.*;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		
		
		IExerciseTypeDao exerciseTypeManager = new ExerciseTypeDaoImpl();
		
		exerciseTypeManager.saveExerciseType(new ExerciseType("Test"));
		
		
		
	}

}
