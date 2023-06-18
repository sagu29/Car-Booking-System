package DAO;

import java.util.List;

import ENTITY.Car;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CarDAOImpl implements CarDAO {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("CarProject");
	}

	@Override
	public void addCar(Car car) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT count(s) FROM Car s WHERE carName = :carName");
			query.setParameter("carName", car.getCarName());
			if ((Long) query.getSingleResult() > 0) {

				throw new SomeThingWentWrongException("Car already exists with name " + car.getCarName());
			}


			et = em.getTransaction();
			et.begin();
			em.persist(car);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Car> getCarLists() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Car> carList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Car s");
			carList = (List<Car>) query.getResultList();
			if (carList.size() == 0) {
				throw new NoRecordFoundException("No Car Found");
			}
		} catch (IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return carList;
	}

	@Override
	public void updateCar(Car car) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Car carFromDB = em.find(Car.class, car.getId());

			if (carFromDB == null) {
				throw new NoRecordFoundException("No Car found with the given id " + car.getId());
			}

			// You are here means car exists with given id
			// check if company is to be renamed
			if (!carFromDB.getCarName().equals(car.getCarName())) {
				// you are here means car is to be renamed, check for no existing car
				// with new name.
				// check if car with same name exists
				Query query = em.createQuery("SELECT count(s) FROM Car s WHERE carName = :carName");

				query.setParameter("stockName", car.getCarName());
				if ((Long) query.getSingleResult() > 0) {
					// you are here means car with given name exists so throw exceptions
					throw new SomeThingWentWrongException("Car already exists with name " + car.getCarName());
				}
			}

			// proceed for update operation

			EntityTransaction et = em.getTransaction();
			et.begin();
			carFromDB.setCarName(car.getCarName());
			carFromDB.setManufacturingYear(car.getManufacturingYear());
			carFromDB.setBrand(car.getBrand());
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	
	
	
	@Override
	public void DeleteCarsById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			// check if car with given id exists
			Car car = em.find(Car.class,id);
			if (car == null) {
				throw new NoRecordFoundException("No car found with the given id " + id);
			}

			// You are here means car exists with given id
		
			et = em.getTransaction();
			et.begin();
			em.remove(car);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

		
	}


}
