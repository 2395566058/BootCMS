package swim.gdkm.dao;

import java.util.List;

import swim.gdkm.poji.Customer;

public interface CustomerDao {
	public List<Customer> selectCustomerList(Customer customer);

	public Integer selectCustomerListCount(Customer customer);

}
