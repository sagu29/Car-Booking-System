package DAO;

import java.util.List;

import ENTITY.Car;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface CarDAO {
	
	void addCar(Car stock) throws SomeThingWentWrongException;
	public List<Car> getCarLists() throws SomeThingWentWrongException, NoRecordFoundException;
	public void updateCar(Car car) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeleteCarsById(int id) throws SomeThingWentWrongException, NoRecordFoundException;
}
