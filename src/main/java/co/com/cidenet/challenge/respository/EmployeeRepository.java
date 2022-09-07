package co.com.cidenet.challenge.respository;

import co.com.cidenet.challenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByFirstLastName(String firstLastName);
    List<Employee> findBySecondLastName(String SecondLastName);
    List<Employee> findByOtherNames(String otherNames);
    List<Employee> findByTypeOfId(String idType);
    List<Employee> findByIdNumber(String idNumber);
    List<Employee> findByCountry(String country);
    List<Employee> findByEmail(String email);
    List<Employee> findByStatus(String status);
    boolean existsByEmail(String email);
}
