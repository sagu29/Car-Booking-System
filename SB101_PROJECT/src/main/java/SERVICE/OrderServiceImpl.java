package SERVICE;

import DAO.OrderDAO;
import DAO.OrderDAOImpl;
import EXCEPTION.SomeThingWentWrongException;

public class OrderServiceImpl implements OrderService {

	@Override
	public void purchaseStock(int carId, String carName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		OrderDAO orderDAO = new OrderDAOImpl();
		orderDAO.purchaseCar(carId, carName);

	}

}
