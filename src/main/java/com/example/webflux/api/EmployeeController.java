package com.example.webflux.api;

import com.example.webflux.document.Employee;
import com.example.webflux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Mono<Employee> getById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public Flux<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public Mono<Employee> save(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Mono<Employee> update(@PathVariable String id, @Valid @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.save(employee);
    }
}
