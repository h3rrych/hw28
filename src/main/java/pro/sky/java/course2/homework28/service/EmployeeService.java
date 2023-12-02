package pro.sky.java.course2.homework28.service;

import pro.sky.java.course2.homework28.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {


    //создание листа сотрудников из Map
    List<Employee> createList();

    Employee add(String firstName, String lastName, double salary, int deparment);

    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Map<String, Employee> findAll() ;


}
