package com.example.webflux.service;

import com.example.webflux.document.Employee;
import com.example.webflux.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    public Mono<Employee> getById(String id) {
        log.info("Finding employee by id: {}", id);
        return employeeRepository.findById(id);
    }

    public Flux<Employee> getAll() {
        log.info("Finding all employees");
        return employeeRepository.findAll();
    }

    public Mono<Employee> save(Employee employee) {
        log.info("Saving employee: {}", employee.toString());
        return employeeRepository.save(employee);
    }

}
