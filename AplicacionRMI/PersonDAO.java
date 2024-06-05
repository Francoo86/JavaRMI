package AplicacionRMI;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class PersonDAO {
    private Dao<Person, String> personDao;

    public PersonDAO(ConnectionSource connectionSource) throws Exception {
        personDao = DaoManager.createDao(connectionSource, Person.class);
        TableUtils.createTableIfNotExists(connectionSource, Person.class);
    }

    public void create(Person person) throws Exception {
        personDao.create(person);
    }

    public Person queryForId(String rut) throws Exception {
        return personDao.queryForId(rut);
    }

    public void update(Person person) throws Exception {
        personDao.update(person);
    }

    public void delete(Person person) throws Exception {
        personDao.delete(person);
    }

    public Person queryForRut(String rut) throws Exception {
        QueryBuilder<Person, String> queryBuilder = personDao.queryBuilder();
        queryBuilder.where().eq("rut", rut);
        return queryBuilder.queryForFirst();
    }
}
