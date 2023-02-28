package com.DailyCodeSample.Springboot.service;

import com.DailyCodeSample.Springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
     Department saveDepartment(Department department);

     List<Department> getDepartments();


     Department getDepartment(Long id);

     void deleteDepartmentById(Long id);

     Department updateDepartmentById(Long id, Department department);

     Department getDepartmentBYName(String name);

}
