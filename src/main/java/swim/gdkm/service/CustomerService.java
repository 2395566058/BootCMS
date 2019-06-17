package swim.gdkm.service;

import swim.gdkm.poji.Customer;
import swim.gdkm.utils.Page;

public interface CustomerService {
	public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource,
			String custIndustry, String custLevel);
}
