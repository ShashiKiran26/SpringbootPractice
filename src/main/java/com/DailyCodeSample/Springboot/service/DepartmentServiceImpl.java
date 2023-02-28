package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.controller.DepartmentController;
import com.DailyCodeSample.Springboot.entity.Department;
import com.DailyCodeSample.Springboot.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Override
    public Department saveDepartment(Department department) {
        LOGGER.info("Hey This is logger in POST method-Repository  method");
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        LOGGER.info("Hey This is logger in GET method-Repository  method");
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        LOGGER.info("Hey This is logger in DELETE method-Repository  method");
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id,  Department department) {
        Department dept =departmentRepository.findById(id).get();

        if (department.getDepartmentName() != "" && department.getDepartmentName() !=null ){
            dept.setDepartmentName(department.getDepartmentName());
        }

        if(department.getDepartmentCode() !="" && department.getDepartmentCode() != null){
            dept.setDepartmentCode(department.getDepartmentCode());
        }

        LOGGER.info("Hey This is logger in UPDATE method-Repository  method");
        return departmentRepository.save(dept);
    }

    @Override
    public Department getDepartmentBYName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }


}
