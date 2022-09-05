package co.com.cidenet.challenge.service;

import co.com.cidenet.challenge.commons.BusinessExceptionHandler;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.model.Employee;
import co.com.cidenet.challenge.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee)
    {
        //[OK]Entry Date validation
        if(employee.getEntryDate().isBefore(LocalDate.now().minusMonths(1)) ||
                employee.getEntryDate().isAfter(LocalDate.now())) {
            throw new BusinessExceptionHandler("Entry date must be up to one month less");
        }

        //[NOK]Email validation - Non-duplicated email validation needed
        final String COLOMBIA_DOMAIN = "@cidenet.com.co";
        final String US_DOMAIN = "@cidenet.com.us";

        String email = employee.getFirstName().toLowerCase(Locale.ROOT)+".";
        email = email.concat(employee.getFirstLastName().toLowerCase(Locale.ROOT).replaceAll("\\s", ""));

        if(employee.getCountry().equals("COLOMBIA"))
            email = email.concat(COLOMBIA_DOMAIN);
        else email = email.concat(US_DOMAIN);

        if(email.length() > 300)
            throw new BusinessExceptionHandler("Email must be up to 300 characters");

        employee.setEmail(email);

        return employeeRepository.save(employee);
    }

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Integer id){
        return employeeRepository.findById(id);
    }

    // Consulting
    public List<Employee> getByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
    public List<Employee> getByFirstLastName(String firstLastName){
        return employeeRepository.findByFirstLastName(firstLastName);
    }
    public List<Employee> getBySecondLastName(String SecondLastName){
        return employeeRepository.findBySecondLastName(SecondLastName);
    }
    public List<Employee> getByOtherNames(String otherNames){
        return employeeRepository.findByOtherNames(otherNames);
    }
    public List<Employee> getByIdType(String idType){
        return employeeRepository.findByTypeOfId(idType);
    }
    public List<Employee> getByIdNumber(String idNumber){
        return employeeRepository.findByIdNumber(idNumber);
    }
    public List<Employee> getByCountry(String country){
        return employeeRepository.findByCountry(country);
    }
    public List<Employee> getByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
    public List<Employee> getByStatus(String status){
        return employeeRepository.findByStatus(status);
    }

    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }

}
