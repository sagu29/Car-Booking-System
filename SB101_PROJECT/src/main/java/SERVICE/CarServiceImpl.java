package SERVICE;

import java.util.List;

import DAO.CarDAO;
import DAO.CarDAOImpl;
import ENTITY.Car;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public class CarServiceImpl {
	

	@Override
	public void addCar(Car car) throws SomeThingWentWrongException {
		CarDAO carDAO = new CarDAOImpl();
		carDAO.addStock(car);
	}

	@Override
	public List<Car> getCarList() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		CarDAO carDAO = new CarDAOImpl();
		return carDAO.getCarList();
	}

	@Override
	public void updateStock(Car car) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CarDAO carDAO = new CarDAOImpl();
		carDAO.updateCar(car);
		
	}

	@Override
	public void DeleteCarById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CarDAO carDAO = new CarDAOImpl();
		carDAO.DeleteCarById(id);
		
	}
	

}
