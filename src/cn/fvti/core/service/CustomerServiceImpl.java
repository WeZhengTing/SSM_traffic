package cn.fvti.core.service;

import cn.fvti.common.utils.Page;
import cn.fvti.core.dao.CustomerDao;
import cn.fvti.core.pojo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel) {
        Customer customer = new Customer();
        if (StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        if (StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        if (StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        if (StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        customer.setStart((page-1)*rows);
        customer.setRows(rows);
        List<Customer> customers=customerDao.selectCustomerList(customer);
        Integer count=customerDao.selectCustomerListCount(customer);
        Page<Customer> result=new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer=customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }

    @Override
    public Customer Customerlogin(String cust_name, String cust_mobile) {
        Customer customer=customerDao.Customerlogin(cust_name,cust_mobile);
        return customer;
    }


}
