package SERVICE;

import java.util.List;

import ENTITY.Customer;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface CustomerService {
	void addCustomer(Customer customer) throws SomeThingWentWrongException;

	List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException;

	void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException;

	void ViewPurchasedStocks() throws SomeThingWentWrongException, NoRecordFoundException;

	void SellStock(int id, String stockName) throws SomeThingWentWrongException, NoRecordFoundException;

	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;

	void deleteAccount() throws SomeThingWentWrongException;

}
