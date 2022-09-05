package co.com.cidenet.challenge.controller;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.mapper.EmployeeMapper;
import co.com.cidenet.challenge.model.Employee;
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
    private EmployeeService employeeService;

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @PostMapping(path = "create")
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest request){

        Employee employee = mapper.toEmployee(request);

        Employee newEmployee = employeeService.save(employee);

        EmployeeResponse employeeResponse = mapper.toEmployeeResponse(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> listAll(){
        List<Employee> employees = employeeService.listAll();
        List<EmployeeResponse> employeeResponses = mapper.toEmployeeResponseList(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.getById(id);

        if(employee.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(mapper.toEmployeeResponse(employee.get()));
    }

    @PutMapping(path = "edit")
    public ResponseEntity<EmployeeResponse> edit(@RequestBody EmployeeRequest request){

        Employee employee = mapper.toEmployee(request);

        Employee  editedEmployee = employeeService.save(employee);

        EmployeeResponse employeeResponse = mapper.toEmployeeResponse(editedEmployee);

        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id)
    {
        employeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
