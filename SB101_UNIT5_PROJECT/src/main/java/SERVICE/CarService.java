package SERVICE;

import java.util.List;

import ENTITY.Car;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface CarService {


	void addCar(Car car) throws SomeThingWentWrongException;
	List<Car> getCarList() throws SomeThingWentWrongException, NoRecordFoundException;
	void updateCar(Car car) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeleteCarById(int id)throws SomeThingWentWrongException, NoRecordFoundException;
}
