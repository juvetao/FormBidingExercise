package se.ecutb.cheng.exercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.ecutb.cheng.exercises.data.CustomerDao;
import se.ecutb.cheng.exercises.dto.CustomerFormDto;
import se.ecutb.cheng.exercises.entity.Customer;
import se.ecutb.cheng.exercises.entity.CustomerDetails;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("customer/create")
    public ModelAndView getForm(){
        CustomerFormDto formDto = new CustomerFormDto();
        ModelAndView model = new ModelAndView();
        model.addObject("form", formDto);
        model.setViewName("create-customer");
        return model;
    }

    @PostMapping("customer/process")
    public String processForm(@Valid @ModelAttribute("form") CustomerFormDto formDto, BindingResult bindingResult){

        if(customerDao.findByEmail(formDto.getEmail()).isPresent()){
            FieldError emailError = new FieldError("form","email","Email " + formDto.getEmail() +" is already defined");
            bindingResult.addError(emailError);
        }

        if(bindingResult.hasErrors()){
            return "create-customer";
        }


        Customer newCustomer= new Customer(formDto.getEmail(), /*formDto.getRegDate(), formDto.isActive(),*/
                new CustomerDetails(formDto.getStreet(), formDto.getZipCode(), formDto.getCity(), formDto.getHomePhone(), formDto.getCellPhone()));
        newCustomer = customerDao.save(newCustomer);


        return "redirect:/customer?type=id&value="+newCustomer.getCustomerId();
    }

    @GetMapping("/customer")
    public String findAll(Model model){
        model.addAttribute("customers", customerDao.findAll());
        return "customers";
    }

    @GetMapping("customers/details")
    public String customer(@RequestParam("id") String customerId, Model model){
        Customer newCustomer = customerDao.findById(customerId).get();
        model.addAttribute("customer", newCustomer);
        return "customer-view";
    }
}
