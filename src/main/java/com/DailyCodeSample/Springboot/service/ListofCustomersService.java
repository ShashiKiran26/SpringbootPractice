package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.entity.*;

import java.util.List;

public interface ListofCustomersService {

    AcessTokenObject getalldata(Loan employeedetails);
    ListofCustomers getCustometersList(String acessKey);

    ListofCustomers getCustometersListbyRequestparams(String authorization, int page, int size);

    ListofCustomers getCustomersListBypost(String authorization, StringQueryParameters queryparameters);

    Customerdbh2object saveCustomerData(Customerdbh2object customer);


    CustomerObject getCustomerDetailsbyCustomerId(String id);


    Object getEmployeeKeysByIndexValue(List<Integer> indexes);

    UserDetails getuserdetailsByid(String id);
}
