package co.com.cidenet.challenge.mapper;

import co.com.cidenet.challenge.dto.request.EmployeeRequest;
import co.com.cidenet.challenge.dto.response.EmployeeResponse;
import co.com.cidenet.challenge.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

    public EmployeeResponse toEmployeeResponse(Employee employee){
        return mapper.map(employee, EmployeeResponse.class);
    }

    public List<EmployeeResponse> toEmployeeResponseList(List<Employee> employees){
        return employees.stream()
                .map(this::toEmployeeResponse)
                .collect(Collectors.toList());
    }

}
