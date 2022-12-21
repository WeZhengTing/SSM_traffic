package cn.fvti.core.controller;

import cn.fvti.common.utils.Page;
import cn.fvti.core.pojo.Cars;
import cn.fvti.core.pojo.Customer;
import cn.fvti.core.pojo.Violation;
import cn.fvti.core.service.CarService;
import cn.fvti.core.service.CustomerService;
import cn.fvti.core.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class ViolationController {

    @Autowired
    private ViolationService violationService;
    @Autowired
    private CarService carsService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/volation/user_list")
    public String list(String cno, Model model){
        try {
            Integer cid=carsService.findCarByCno(cno);
            System.out.println("车号是"+cid);
            Page<Violation> violation=violationService.findViolationList(cid);
            model.addAttribute("page1",violation);
            model.addAttribute("cno",cno);
            System.out.println(violation.getRows());
            model.addAttribute("msg","请及时处理违章信息");
        }
        catch (Exception e){
            model.addAttribute("msg","没有查询到相关信息");
        }
        return "User_user";
    }


    @RequestMapping(value = "/violation/Vbill")
    public String vbill(Integer vid, Model model, Customer customer, HttpSession session){
        try{
            Violation violation=violationService.vgetuid(vid);
            int cust_id=violation.getCust_id();
            int vcount=violation.getVmoney();
            int vlicense=violation.getVlicense();
            String vstate=violation.getVstare();

            //获取当前用户
            String name1 = (String) session.getAttribute("customer_names");
            String mobiles1 = (String) session.getAttribute("customer_mobiles");
            Customer customer1 = customerService.Customerlogin(name1, mobiles1);

            if (vstate.equals("未处理")) {
                customer = customerService.getCustomerById(cust_id);//罚单车主
                int license=customer.getCust_license();
                int ccount = customer1.getCust_count();
                System.out.println("user name:"+customer.getCust_name()+"user count:"+ccount+"vcount:"+vcount);


                if (vcount>ccount){model.addAttribute("ms","账户余额不足");}
                else {
                    customer.setCust_count(ccount-vcount);
                    customer.setCust_license(license-vlicense);
                    customerService.updateCustomer(customer);
                    violation.setVstare("完成");
                    violationService.updateviolation(violation);
                    model.addAttribute("ms","处理完成");
                    System.out.println(violation.getVmoney()+violation.getVlicense());
                }
            }
            else {
                model.addAttribute("ms","已处理");
            }

        }catch (Exception e){
            model.addAttribute("ms","未查询到罚单信息");
        }
        return "User_change_VIP";
    }

    @RequestMapping(value = "/violation/createcount")
    public String createcount(Model model, HttpSession session){
        try {
            String name = (String) session.getAttribute("customer_names");
            String mobiles = (String) session.getAttribute("customer_mobiles");
            Customer customer = customerService.Customerlogin(name, mobiles);
            customer.setCust_count(customer.getCust_count() + 100);
            customerService.updateCustomer(customer);
            model.addAttribute("ms","充值成功,账户余额："+customer.getCust_count());
        }
        catch (Exception e){
            model.addAttribute("ms","充值失败");
        }
        return "User_change_VIP";
    }




    @RequestMapping(value = "/violation/sign")
    public String v_sign(Violation violation,Model model,String cno){

        try {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            violation.setVtime(timestamp);
            int cid = carsService.findCarByCno(cno);
            System.out.println(cid);
            violation.setCid(cid);
            violation.setCust_id(carsService.finduidByCid(cid));
            violationService.insertviolation(violation);
            model.addAttribute("vms","登记成功");
        }catch (Exception e) {
            model.addAttribute("vms","登记失败");
            System.out.println(e);
        }
        return "User_VIP";
    }

}



