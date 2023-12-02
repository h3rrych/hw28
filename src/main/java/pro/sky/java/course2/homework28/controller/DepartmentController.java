package pro.sky.java.course2.homework28.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.DepartmentService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}/max-salary")
    public Employee findEmployeeMaxSalaryInDepartment(@PathVariable("id") int dep) {
        return service.findEmployeeMaxSalaryInDepartment(dep);
    }

    @GetMapping("/{id}/min-salary")
    public Employee findEmployeeMinSalaryInDepartment(@PathVariable("id") int dep) {
        return service.findEmployeeMinSalaryInDepartment(dep);
    }

    @GetMapping("/{id}/all")
    public List<Employee> findAllDepartment(@PathVariable("id") int dep) {
        return service.findAllDepartment(dep);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllDepartmentAll() {
        return service.findAllDepartmentAll();
    }

    @GetMapping("/{id}/salary/sum")
    public Double sumSalaryDepartment(@PathVariable("id") int dep) {
        return service.sumSalary(dep);
    }

}

