package cn.fvti.core.controller;

import cn.fvti.common.utils.Page;
import cn.fvti.core.pojo.BaseDict;
import cn.fvti.core.pojo.Customer;
import cn.fvti.core.pojo.User;
import cn.fvti.core.service.BaseDictService;
import cn.fvti.core.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    @RequestMapping(value = "/customer/list.action")
    public String list(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer rows,
                       String custName, String custSource, String custIndustry, String custLevel, Model model){
        Page<Customer> customers=customerService.findCustomerList(page,rows,custName,custSource,custIndustry,custLevel);
        model.addAttribute("page",customers);
        List<BaseDict> fromType=baseDictService.findBaseDictByTypeCode(FROM_TYPE);
        List<BaseDict> industryType=baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
        List<BaseDict> levelType=baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("custName",custName);
        model.addAttribute("custSource",custSource);
        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("custLevel",custLevel);
        return "customer";
    }
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){
        User user = (User) session.getAttribute("USER_SESSION");
        customer.setCust_create_id(user.getUser_id());
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        int rows=customerService.createCustomer(customer);
        if (rows>0){
            return "OK";
        }else{
            return "FAIL";
        }
    }


    @RequestMapping("/customer/User_sign")
    public String customer_sign(Customer customer,Model model){
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        customer.setCust_level("22");
        customer.setCust_industry("3");
        customer.setCust_source("7");
        customer.setCust_count(0);
        customer.setCust_license(0);
        customer.setCust_policeno(0);
        System.out.println(customer.getCust_id());
        int rows=customerService.createCustomer(customer);
        String Page="#";
        if (rows>0){
            Page= "User_login";
        }else{
            model.addAttribute("ms","出现错误，请重新操作");
            Page= "User_sign";
        }
        return Page;
    }






    @RequestMapping("/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }
    @RequestMapping("/customer/update.action")
    @ResponseBody
    public String customerUpdate(Customer customer){
        int rows=customerService.updateCustomer(customer);
        if (rows>0){
            return "OK";
        }else {
            return "FAIL";
        }
    }
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String customerDelete(Integer id){
        int rows=customerService.deleteCustomer(id);
        if (rows>0){
            return "OK";
        }else {
            return "FAIL";
        }
    }


    @RequestMapping(value="/Customer_login")                               /*用户跳转登入*/
    public String login_null(){
        return "User_login";
    }



    @RequestMapping(value="/Customer_login_OK")                               /*用户登入*/
    public String login(String cust_name,String cust_mobile,Model model,HttpSession session){
        String page="User_login";
        try {
            Customer customer = customerService.Customerlogin(cust_name, cust_mobile);
            System.out.println(customer.getCust_mobile());
            if (customer != null) {
                String level = customer.getCust_level();
                session.setAttribute("customer_mobiles", customer.getCust_mobile());
                session.setAttribute("customer_names", customer.getCust_name());
                session.setAttribute("customer_license",customer.getCust_license());
                session.setAttribute("customer_count",customer.getCust_count());
                System.out.println(level);
                if (level.equals("23")) {
                    System.out.println("警察");
                    page="User_VIP";
                } else{
                    System.out.println("用户");
                    model.addAttribute("Use_message", "登入成功");
                    page= "User_user";
                }
            } else {

                page="User_login";
            }
        }catch (Exception e){
            model.addAttribute("Use_message", "未查询到相关信息，请重新登入");
        }
        return page;
    }

    @RequestMapping(value="/toUser_VIP")                               /*用户跳转登入*/
    public String login_vip(){
        return "User_change_VIP";
    }

    @RequestMapping(value = "/User_change_level")
    public String Change_vip(HttpSession session){
        String name= (String) session.getAttribute("customer_names");
        String mobiles= (String) session.getAttribute("customer_mobiles");
        System.out.println(name);
        System.out.println(mobiles);
        Customer customer=customerService.Customerlogin(name,mobiles);
        customer.setCust_level("23");
        customerService.updateCustomer(customer);
        System.out.println(customer.getCust_level());
        return "User_VIP";
    }

    @RequestMapping(value = "/toAdministrator")
    public String toAdministrator(){
        return "login";
    }

    @RequestMapping(value = "/toselect")
    public String toselect(){
        return "select";
    }



}

