package cn.fvti.core.service;

import cn.fvti.common.utils.Page;
import cn.fvti.core.pojo.Customer;

public interface CustomerService {
    public Page<Customer> findCustomerList(Integer page,Integer rows,String custName,String custSource,String custIndustry,String custLevel);

    public int createCustomer(Customer customer);

    public Customer getCustomerById(Integer id);

    public int updateCustomer(Customer customer);

    public int deleteCustomer(Integer id);

    public Customer Customerlogin(String cust_name, String cust_mobile);
}
