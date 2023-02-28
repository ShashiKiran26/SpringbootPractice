package com.DailyCodeSample.Springboot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.DailyCodeSample.Springboot.entity.Customerdbh2object;
import com.DailyCodeSample.Springboot.entity.ListofCustomers;
import com.DailyCodeSample.Springboot.entity.StringQueryParameters;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.DailyCodeSample.Springboot.repository.*;
import java.util.Collections;
import com.DailyCodeSample.Springboot.entity.*;
@Service
public class ListofCustomersimpl implements ListofCustomersService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CoustomerDataRepository coustomerDataRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Autowired
    private RestTemplate restTemplate;

    ObjectMapper objectMapper =new ObjectMapper();

    private final Logger LOGGER = LoggerFactory.getLogger(ListofCustomersimpl.class);

    @Override
    public AcessTokenObject getalldata(Loan employeedetails) {
        String url= "https://uat-dlp.ashvfinance.com/api/auth/users/login";

        HttpEntity<Loan> entity = new HttpEntity<Loan>(employeedetails,null);

        AcessTokenObject ss = restTemplate.exchange(url, HttpMethod.POST, entity, AcessTokenObject.class).getBody();

        return ss;
    }


    @Override
    public ListofCustomers getCustometersList(String accessKey) {
        String url="https://uat-dlp.ashvfinance.com/api/search/loans?page=1&size=10";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+accessKey);
        LOGGER.info("I am 1");
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        LOGGER.info("I am 2");
        String result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        ListofCustomers result2 = null;
        try {
            result2 = objectMapper.readValue(result, ListofCustomers.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        coustomerDataRepository.saveAll(result2.getData());
        for (CustomerObject object : result2.getData()){
            String appId = object.getApplicationid();
            CustomerObject obj=coustomerDataRepository.findByApplicationid(appId);
            if (obj== null){
                coustomerDataRepository.save(object);
            }
        }
        return (ListofCustomers) result2;
    }


    @Override
    public ListofCustomers getCustometersListbyRequestparams(String authorization, int page, int size) {
        String url="https://uat-dlp.ashvfinance.com/api/search/loans?page="+page+"&size="+size;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorization);
        LOGGER.info("I am 1");
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        LOGGER.info("I am 2");
        String result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

//        customerRepository.saveAll(result.getData())
//        System.out.println(result.getData().get(0));

        ListofCustomers result2 = null;
        try {
            result2 = objectMapper.readValue(result, ListofCustomers.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        coustomerDataRepository.saveAll(result2.getData());
        for (CustomerObject object : result2.getData()){
            String appId = object.getApplicationid();
            CustomerObject obj=coustomerDataRepository.findByApplicationid(appId);
            if (obj== null){
                coustomerDataRepository.save(object);
            }
        }
        return (ListofCustomers) result2;
    }

    @Override
    public ListofCustomers getCustomersListBypost(String authorization, StringQueryParameters queryparameters) {
        String url="https://uat-dlp.ashvfinance.com/api/search/loans?page="+
                queryparameters.getPage()+"&size="+queryparameters.getSize();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorization);
        LOGGER.info("I am 1");
        HttpEntity<StringQueryParameters> entity = new HttpEntity<StringQueryParameters>(null,headers);

        String result = restTemplate.exchange(url,HttpMethod.GET,entity, String.class).getBody();

        ListofCustomers result2 = null;
        try {
            result2 = objectMapper.readValue(result, ListofCustomers.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        icoustomerDataRepository.saveAll(result2.getData());
        for (CustomerObject object : result2.getData()){
            String appId = object.getApplicationid();
            CustomerObject obj=coustomerDataRepository.findByApplicationid(appId);
            if (obj== null){
                coustomerDataRepository.save(object);
            }
        }
        return (ListofCustomers) result2;
    }

    @Override
    public Customerdbh2object saveCustomerData(Customerdbh2object customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerObject getCustomerDetailsbyCustomerId(String id) {
        return coustomerDataRepository.findByApplicationid(id);
    }

    @Override
    public Object getEmployeeKeysByIndexValue(List<Integer> indexes) {
        String url ="https://uat-dlp.ashvfinance.com/api/auth/group/members";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String authorization="Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJtRk9MSkpuMHZQd2cwSVU0ZWM2cmVIUUZ5bEdLeEVCekhLODMtVV9VVE9FIn0.eyJqdGkiOiJiNTlhYmUxZC02MTkyLTRlMGMtYjA1ZC05MGQ4ZWRhOGMzZmIiLCJleHAiOjE2Nzc2Nzk5MTQsIm5iZiI6MCwiaWF0IjoxNjc3MDc1MTE0LCJpc3MiOiJodHRwczovL3VhdC1hYS5hc2h2ZmluYW5jZS5jb20vYXV0aC9yZWFsbXMvdHJpYmUzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijk3MTJlOTc4LWQ4NDUtNDRmMi04ZmNhLTBmN2I4ZjlkMjk5MyIsInR5cCI6IkJlYXJlciIsImF6cCI6Im1pY3JvLWNsaWVudCIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjdkOWM1Y2U4LTY0ZjItNGMzOS05OTI2LTE2MWRkOTViOGNhZCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly91YXQtZGxwLmFzaHZmaW5hbmNlLmNvbSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJBU0hWX0lUX0FETUlOIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm9yZ2FuaXphdGlvbiI6ImFzaHYiLCJuYW1lIjoiU2hhc2hpIEIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzaGFzaGlraXJhbi5iQGFzaHZmaW5hbmNlLmNvbSIsImdpdmVuX25hbWUiOiJTaGFzaGkiLCJmYW1pbHlfbmFtZSI6IkIiLCJlbWFpbCI6InNoYXNoaWtpcmFuLmJAYXNodmZpbmFuY2UuY29tIiwidXNlcl9ncm91cHMiOlsiSVQgQWRtaW4iXX0.G0O794iz32ovEfoXMPWAWpr7RZ1CIhHQckqat6ysPDiFtalT31qiR-RzddqSnC7GYqfGuw2lk3Bm5aUhFGOA-lgWbwkPtz01YaIYslKk-3TDb3Oy3d9KB5AhiPBk6mXPZbF5ziRq9mGZHrk59xoOWueKq40A7pTbr2EHrugA-xUe6hoq5JI9JcW2oTIaF61-PoyR8QNEv4qfXs-_1ZAVc1Guo5EUE0LYOeXRaNa6te0Q-UvkH3xvTBKiA0-khp1RwL_ZWXnLf0RJvyN9jcNa60w3dPKU-YjDQqfVBO9gV2HYEg-9DI21I0Pl-bnLr9x7mOSgVm143zIqwkbMy-V5VQ";
        headers.set("Authorization", authorization);
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        String result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

//        List<KeyObject> Employees =new ArrayList<>();

        List<KeyObject> result2 = new ArrayList<>();
        try {
            result2 = objectMapper.readValue(result, new TypeReference<List<KeyObject>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//
//        for (KeyObject n : (ArrayList) result){
//            Employees.add(n);
//        }

        List<String> keys = new ArrayList<>();

        for(int n: indexes){
            String k=(result2).get(n).getKey();
            keys.add(k);
        }

        System.out.println(keys);

        String url1 ="https://uat-dlp.ashvfinance.com/api/user-svc/users/info";
        HttpEntity<List<String>> entity1 = new HttpEntity<List<String>>(keys,headers);

        String listofusers = restTemplate.exchange(url1, HttpMethod.POST, entity1, String.class).getBody();


        List<UserDetails> result3 = new ArrayList<>();
        try {
            result3 = objectMapper.readValue(listofusers, new TypeReference<List<UserDetails>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        ListOfUserDetails result3 =null;
//        try {
//            result3 = objectMapper.readValue(listofusers,ListOfUserDetails.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }



        for (UserDetails user: result3){
            UserDetails userfromdb = userDetailsRepository.findByUserId(user.getUserId());

            if(userfromdb==null){
                userDetailsRepository.save(user);
            }
            System.out.println(user.getUserId());
        }


        return listofusers;
    }

    @Override
    public UserDetails getuserdetailsByid(String id) {
        UserDetails user= userDetailsRepository.findByUserId(id);

        return user;
    }

}
