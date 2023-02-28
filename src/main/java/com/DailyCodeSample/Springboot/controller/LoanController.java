package com.DailyCodeSample.Springboot.controller;

import com.DailyCodeSample.Springboot.entity.AcessTokenObject;
import com.DailyCodeSample.Springboot.entity.Loan;
import com.DailyCodeSample.Springboot.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {
    @Autowired
    private LoanService loandetails;
    @PostMapping(value="/employeedetails",consumes = "application/json", produces = "application/json")
    public AcessTokenObject getalldata(@RequestBody Loan employeedetails){
        return loandetails.getalldata(employeedetails);
    }
}
