package AplicacionRMI;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
//IMPORT THE ENV THING

public class VehicleDAO {
    private Dao<Vehicle, String> vehicleDao;

    public VehicleDAO(ConnectionSource connectionSource) throws Exception {
        vehicleDao = DaoManager.createDao(connectionSource, Vehicle.class);
        TableUtils.createTableIfNotExists(connectionSource, Vehicle.class);
    }

    public void create(Vehicle vehicle) throws Exception {
        vehicleDao.create(vehicle);
    }

    public Vehicle queryForId(String placa) throws Exception {
        return vehicleDao.queryForId(placa);
    }

    public void update(Vehicle vehicle) throws Exception {
        vehicleDao.update(vehicle);
    }

    public void delete(Vehicle vehicle) throws Exception {
        vehicleDao.delete(vehicle);
    }

    public Vehicle queryForPlaca(String placa) throws Exception {
        QueryBuilder<Vehicle, String> queryBuilder = vehicleDao.queryBuilder();
        queryBuilder.where().eq("placa", placa);
        return queryBuilder.queryForFirst();
    }
}
