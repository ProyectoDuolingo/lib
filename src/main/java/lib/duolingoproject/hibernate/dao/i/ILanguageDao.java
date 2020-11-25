package lib.duolingoproject.hibernate.dao.i;

import java.util.List;

import lib.duolingoproject.hibernate.model.Language;

public interface ILanguageDao {

	public Language getLanguageById(long id);
	public List<Language> getAllLanguages();
	public void saveLanguage(Language language);
	public void updateLanguage(Language language);
	public void deleteLanguageById(long id);
}
