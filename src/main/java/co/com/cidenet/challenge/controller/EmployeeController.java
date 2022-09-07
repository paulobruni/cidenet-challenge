package co.com.cidenet.challenge.controller;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.mapper.EmployeeMapper;
import co.com.cidenet.challenge.model.Employee;
import co.com.cidenet.challenge.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest request){

        Employee employee = mapper.toEmployee(request);

        employee.setCountry(employee.getCountry().toUpperCase(Locale.ROOT));

        employee.setTypeOfId(employee.getTypeOfId().toUpperCase(Locale.ROOT));

        employee.setArea(employee.getArea().toUpperCase(Locale.ROOT));

        Employee newEmployee = employeeService.save(employee, 'c');

        EmployeeResponse employeeResponse = mapper.toEmployeeResponse(newEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> listAll(){
        List<Employee> employees = employeeService.listAll();
        List<EmployeeResponse> employeeResponses = mapper.toEmployeeResponseList(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.getById(id);

        if(employee.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(mapper.toEmployeeResponse(employee.get()));
    }

    /*
    *
    * Begin Consulting Endpoints
    *
    * */
    @GetMapping("/firstname={firstName}")
    public ResponseEntity<List<EmployeeResponse>> getByFirstName(@PathVariable String firstName){
        List<EmployeeResponse> employeeResponses = search(firstName, "firstName");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/firstlastname={firstLastName}")
    public ResponseEntity<List<EmployeeResponse>> getByFirstLastName(@PathVariable String firstLastName){
        List<EmployeeResponse> employeeResponses = search(firstLastName, "firstLastName");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/secondlastname={secondLastName}")
    public ResponseEntity<List<EmployeeResponse>> getBySecondLastName(@PathVariable String secondLastName){
        List<EmployeeResponse> employeeResponses = search(secondLastName, "secondLastName");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/othernames={otherNames}")
    public ResponseEntity<List<EmployeeResponse>> getByOtherNames(@PathVariable String otherNames){
        List<EmployeeResponse> employeeResponses = search(otherNames, "otherNames");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/typeofid={typeOfId}")
    public ResponseEntity<List<EmployeeResponse>> getByTypeOfId(@PathVariable String typeOfId){
        List<EmployeeResponse> employeeResponses = search(typeOfId, "typeOfId");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/idnumber={idNumber}")
    public ResponseEntity<List<EmployeeResponse>> getByIdNumber(@PathVariable String idNumber){
        List<EmployeeResponse> employeeResponses = search(idNumber, "idNumber");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/email={email}")
    public ResponseEntity<List<EmployeeResponse>> getByEmail(@PathVariable String email){
        List<EmployeeResponse> employeeResponses = search(email, "email");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/country={country}")
    public ResponseEntity<List<EmployeeResponse>> getByCountry(@PathVariable String country){
        List<EmployeeResponse> employeeResponses = search(country, "country");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/status={status}")
    public ResponseEntity<List<EmployeeResponse>> getByStatus(@PathVariable String status){
        List<EmployeeResponse> employeeResponses = search(status, "status");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    /*
     *
     * End Consulting Endpoints
     *
     * */

    @PutMapping(path = "/edit={id}")
    public ResponseEntity<EmployeeResponse> edit(@PathVariable Integer id, @RequestBody EmployeeRequest request){

        Optional<Employee> currentEmployee = employeeService.getById(id);

        if(currentEmployee.isEmpty())
            return ResponseEntity.notFound().build();

        Employee newEmployee = mapper.toEmployeeEdit(request, currentEmployee.get());

        Employee editedEmployee = employeeService.save(newEmployee, 'e');

        EmployeeResponse employeeResponse = mapper.toEmployeeResponse(editedEmployee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id)
    {
        employeeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    protected List<EmployeeResponse> search(String param, String search)
    {
        List<Employee> employees = new ArrayList<>();

        switch (search)
        {
            case "firstName":
                employees = employeeService.getByFirstName(param.toUpperCase(Locale.ROOT));
            break;
            case "firstLastName":
                employees = employeeService.getByFirstLastName(param.toUpperCase(Locale.ROOT));
            break;
            case "secondLastName":
                employees = employeeService.getBySecondLastName(param.toUpperCase(Locale.ROOT));
            break;
            case "otherNames":
                employees = employeeService.getByOtherNames(param.toUpperCase(Locale.ROOT));
            break;
            case "country":
                employees = employeeService.getByCountry(param.toUpperCase(Locale.ROOT));
            break;
            case "typeOfId":
                employees = employeeService.getByIdType(param.toUpperCase(Locale.ROOT));
            break;
            case "idNumber":
                employees = employeeService.getByIdNumber(param);
            break;
            case "email":
                employees = employeeService.getByEmail(param);
            break;
            case "status":
                employees = employeeService.getByStatus(param.toUpperCase(Locale.ROOT));
            break;
        }

        List<EmployeeResponse> employeeResponses = mapper.toEmployeeResponseList(employees);

        return employeeResponses;
    }

}
