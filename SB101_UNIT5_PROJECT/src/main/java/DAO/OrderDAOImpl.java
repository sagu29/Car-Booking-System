package DAO;

import java.util.Set;

import ENTITY.Car;
import ENTITY.Customer;
import ENTITY.LoggedInUserId;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void purchaseCar(int carId, String carName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Car s WHERE carName = :carName");
			query.setParameter("carName", carName);
			// Here we can use getSingleResult because we are sure that plan exists with
			// given name
			Car car = (Car) query.getSingleResult();
			// get the entity of Customer
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);

			Set<Car> carSet = customer.getOrderCarSet();
			carSet.add(car);
			customer.setOrderCarSet(carSet);

			Set<Customer> cusSet = car.getCustomer();
			cusSet.add(customer);
			car.setCustomer(cusSet);

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		} catch (PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

}
