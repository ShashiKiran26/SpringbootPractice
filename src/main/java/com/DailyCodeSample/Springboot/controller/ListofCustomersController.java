package com.DailyCodeSample.Springboot.controller;

import com.DailyCodeSample.Springboot.entity.AcessTokenObject;
import com.DailyCodeSample.Springboot.entity.*;
import com.DailyCodeSample.Springboot.entity.Loan;
import com.DailyCodeSample.Springboot.entity.StringQueryParameters;
import com.DailyCodeSample.Springboot.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
public class ListofCustomersController {

    @Autowired
    private ListofCustomersService customersList;

    private final Logger LOGGER = LoggerFactory.getLogger(ListofCustomersController.class);

    @PostMapping(value="/employeedetails2",consumes = "application/json", produces = "application/json")
    public ListofCustomers getalldata(@RequestBody Loan employeedetails){
        AcessTokenObject acesssKey= customersList.getalldata(employeedetails);
        String acessToken = acesssKey.getAccess_token();

        ListofCustomers result= getCustometersList(acessToken);

        return result;
    }



//    @GetMapping(value="/customerdetails",produces = "application/json",consumes = "application/json")
    public ListofCustomers getCustometersList(String accessKey){
        LOGGER.info("Hey I am logger 1");
        return customersList.getCustometersList(accessKey);
    };

//    @GetMapping(value="/customerdetails",produces = "application/json",consumes = "application/json")
//    public ListofCustomers getCustometersList(@RequestHeader String accessKey){
//        LOGGER.info("Hey I am logger 1");
//        return customersList.getCustometersList(accessKey);
//    };

    @GetMapping(value="/customerdetails/{page}/{size}",produces = "application/json",consumes = "application/json")
    public Object getCustometersListbyRequestparams(HttpServletRequest accessKey,
                                                          @PathVariable("page") int page,
                                                          @PathVariable("size") int size){
        LOGGER.info("Hey I am logger 1");
        return customersList.getCustometersListbyRequestparams(accessKey.getHeader("Authorization"),page,size);
    };

    @PostMapping(value="/customerdetails",consumes = "application/json", produces = "application/json")
    public ListofCustomers getCustomersListBypost(HttpServletRequest accessKey,
                                                  @RequestBody StringQueryParameters queryparameters){
        return customersList.getCustomersListBypost(accessKey.getHeader("Authorization"),queryparameters);
    }


    @PostMapping(value="/customerdetailspost")
    public Customerdbh2object saveCustomerData(@RequestBody Customerdbh2object Customer){
        return customersList.saveCustomerData(Customer);
    }

    @GetMapping("/customerdetailspost/id/{id}")
    public CustomerObject getDepartmentBYName(@PathVariable("id") String Id){
        return  customersList.getCustomerDetailsbyCustomerId(Id);
    }


    @PostMapping("/EmployeeList")
    public Object getEmployeeKeysByIndexValue(@Valid @RequestBody List<Integer> indexes){
        return customersList.getEmployeeKeysByIndexValue(indexes);
    }

    @GetMapping("/GetUserdetailsById/{id}")
    public UserDetails getuserdetailsByid(@PathVariable("id") String id){
        return customersList.getuserdetailsByid(id);
    }
}
