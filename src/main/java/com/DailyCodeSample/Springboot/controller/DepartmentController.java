package com.DailyCodeSample.Springboot.controller;

import com.DailyCodeSample.Springboot.entity.Department;
import com.DailyCodeSample.Springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Hey This is logger in Post method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("Hey This is logger in Get method");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long Id){
        LOGGER.info("Hey This is logger in GetById  method");
        return departmentService.getDepartment(Id);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentBYName(@PathVariable("name") String name){
        LOGGER.info("Hey This is logger in GetByName  method");
        return  departmentService.getDepartmentBYName(name);
    }



    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long ID){
        LOGGER.info("Hey This is logger in DELETE  method");
        departmentService.deleteDepartmentById(ID);
        return "Deleted Sucessfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long ID,
                                           @RequestBody Department department){
        LOGGER.info("Hey This is logger in Update  method");
        return departmentService.updateDepartmentById(ID,department);
    }



}
