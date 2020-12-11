package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Category;

public interface ICategoryDao {

	public Category getCategoryById(long id);
	public List<Category> getAllCategoriesByCourseId(long id);
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategoryById(long id);
	
}
