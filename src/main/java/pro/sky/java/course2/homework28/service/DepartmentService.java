package pro.sky.java.course2.homework28.service;

import pro.sky.java.course2.homework28.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeMaxSalaryInDepartment(int depart);

    Employee findEmployeeMinSalaryInDepartment(int depart);

    List<Employee> findAllDepartment(int depart);

    Map<Integer, List<Employee>> findAllDepartmentAll();

    Double sumSalary(int depart);
}
