package co.com.cidenet.challenge.mapper;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.model.Employee;

public class EmployeeMapper {

    public static Employee toEmployee(EmployeeRequest request){

        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setFirstLastName(request.getFirstLastName());
        employee.setSecondLastName(request.getSecondLastName());
        employee.setOtherNames(request.getOtherNames());
        employee.setCountry(request.getCountry());
        employee.setTypeOfId(request.getTypeOfId());
        employee.setIdNumber(request.getIdNumber());
        employee.setEntryDate(request.getEntryDate());
        employee.setArea(request.getArea());

        return employee;

    }

    public static EmployeeResponse toEmployeeResponse(Employee employee){

        EmployeeResponse response = new EmployeeResponse();

        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setFirstLastName(employee.getFirstLastName());
        response.setSecondLastName(employee.getSecondLastName());
        response.setOtherNames(employee.getOtherNames());
        response.setCountry(employee.getCountry());
        response.setTypeOfId(employee.getTypeOfId());
        response.setIdNumber(employee.getIdNumber());
        response.setEmail(employee.getEmail());
        response.setEntryDate(employee.getEntryDate());
        response.setEditDate(employee.getEditDate());
        response.setStatus(employee.getStatus());
        response.setArea(employee.getArea());
        response.setLog(employee.getLog());

        return response;

    }

}
