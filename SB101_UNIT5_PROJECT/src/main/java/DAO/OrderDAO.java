package DAO;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderDAO {

	void purchaseCar(int carId,String carName) throws SomeThingWentWrongException;
}
