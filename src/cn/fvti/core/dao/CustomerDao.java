package cn.fvti.core.dao;

import cn.fvti.core.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    public List<Customer>selectCustomerList(Customer customer);
    public Integer selectCustomerListCount(Customer customer);
    public int createCustomer(Customer customer);
    public Customer getCustomerById(Integer id);
    public int updateCustomer(Customer customer);
    int deleteCustomer(Integer id);
    public Customer Customerlogin(@Param("cust_name") String cust_name,@Param("cust_mobile")  String cust_mobile);

}
