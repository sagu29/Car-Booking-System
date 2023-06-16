package SERVICE;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderService {

	public void purchaseCar(int carId, String carName)throws SomeThingWentWrongException;
}
