package cn.fvti.core.controller;

import cn.fvti.core.pojo.Cars;
import cn.fvti.core.pojo.Customer;
import cn.fvti.core.service.CarService;
import cn.fvti.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class CarsController {
    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/car/carsign")
    public String carsign(String cname, String cuser, String ccolor, String cno, String cust_name, String mobile, Cars cars, Model model){
        try{
            Date date=new Date();
            Timestamp timestamp=new Timestamp(date.getTime());
            Customer customer=customerService.Customerlogin(cust_name,mobile);
            System.out.println(customer.getCust_name());
            Integer id=customer.getCust_id();
            cars.setCname(cname);
            cars.setCuser(cuser);
            cars.setCcolor(ccolor);
            cars.setCno(cno);
            cars.setCust_id(id);
            cars.setCbirthday(timestamp);
            carService.createcar(cars);
            model.addAttribute("carms","车辆登记成功");

        }catch (Exception e){
            System.out.println(e);
            model.addAttribute("carms","车辆登记失败");
        }
        return "User_VIP";
    }
}
