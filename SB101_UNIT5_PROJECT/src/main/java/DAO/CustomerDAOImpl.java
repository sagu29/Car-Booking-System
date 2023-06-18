package DAO;

import java.util.List;
import java.util.Set;

import ENTITY.Car;
import ENTITY.Customer;
import ENTITY.LoggedInUserId;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Object[]> customerList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT c.name, c.username, c.dateOfBirth, c.isDeleted FROM Customer c");
			customerList = query.getResultList();
			if (customerList.size() == 0) {
				throw new NoRecordFoundException("No Customer Found");
			}
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return customerList;
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery(
					"SELECT c.id FROM Customer c WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>) query.getResultList();
			if (listInt.size() == 0) {
				// you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public void ViewPurchasedCars() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			Set<Car> purchasedCarList = customer.getOrderCarSet();

			if (purchasedCarList.isEmpty()) {
				throw new NoRecordFoundException("No Car Purched By You");
			}
			for (Car s : purchasedCarList) {
				System.out.println("Id : " + s.getId() + " Name : " + s.getCarName() + " Price : " + s.getCarPrice()
						+ " Year : " + s.getManufacturingYear());
			}

		} catch (PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

	}

	

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			Long userCount = (Long) query.getSingleResult();
			if (userCount == 0) {
				// you are here old password is incorrect for logged in user
				throw new SomeThingWentWrongException("Invalid old password");
			}
			// You are here means all checks done, We can proceed for changing the password
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setPassword(newPassword);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if customer with same username exists
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE username = :username");
			query.setParameter("username", customer.getUsername());  
			if((Long)query.getSingleResult() > 0) {
				//you are here means customer with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username" + customer.getUsername() + " is already occupied");
			}
			//you are here means no customer with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	
}
