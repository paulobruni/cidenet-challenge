package co.com.cidenet.challenge.controller;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.mapper.EmployeeMapper;
import co.com.cidenet.challenge.model.Employee;
import co.com.cidenet.challenge.respository.EmployeeRepository;
import co.com.cidenet.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "create")
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest request){

        Employee employee = EmployeeMapper.toEmployee(request);

        Employee newEmployee = employeeService.save(employee);

        EmployeeResponse employeeResponse = EmployeeMapper.toEmployeeResponse(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> listAll(){
        List<Employee> employees = employeeService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.getById(id);

        if(employee.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(employee.get());
    }

    @PutMapping(path = "edit")
    public ResponseEntity<Employee> edit(@RequestBody Employee employee){

        Employee editedEmployee = employeeService.save(employee);

        return ResponseEntity.status(HttpStatus.OK).body(editedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id)
    {
        employeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
