package co.com.cidenet.challenge.mapper;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    private final ModelMapper mapper;

    public EmployeeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Employee toEmployee(EmployeeRequest request) {
        return mapper.map(request, Employee.class);
    }

    public Employee toEmployeeEdit(EmployeeRequest request, Employee currentEmployee) {

        Employee editEmployee = mapper.map(request, Employee.class);

        if(!currentEmployee.getFirstName().equals(editEmployee.getFirstName()))
            currentEmployee.setFirstName(editEmployee.getFirstName());

        if(!currentEmployee.getFirstLastName().equals(editEmployee.getFirstLastName()))
            currentEmployee.setFirstLastName((editEmployee.getFirstLastName()));

        if(!currentEmployee.getSecondLastName().equals(editEmployee.getSecondLastName()))
            currentEmployee.setSecondLastName(editEmployee.getSecondLastName());

        if(currentEmployee.getOtherNames() != editEmployee.getOtherNames())
            currentEmployee.setOtherNames(editEmployee.getOtherNames());

        if(!currentEmployee.getCountry().equals(editEmployee.getCountry()))
            currentEmployee.setCountry(editEmployee.getCountry());

        if(!currentEmployee.getTypeOfId().equals(editEmployee.getTypeOfId()))
            currentEmployee.setTypeOfId(editEmployee.getTypeOfId());

        if(!currentEmployee.getIdNumber().equals(editEmployee.getIdNumber()))
            currentEmployee.setIdNumber(editEmployee.getIdNumber());

        if(!currentEmployee.getArea().equals(editEmployee.getArea()))
            currentEmployee.setArea(editEmployee.getArea());

        currentEmployee.setEditDate(LocalDate.now());

        return currentEmployee;
    }

    public EmployeeResponse toEmployeeResponse(Employee employee){
        return mapper.map(employee, EmployeeResponse.class);
    }

    public List<EmployeeResponse> toEmployeeResponseList(List<Employee> employees){
        return employees.stream()
                .map(this::toEmployeeResponse)
                .collect(Collectors.toList());
    }


}
