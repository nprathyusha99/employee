package empService;

import java.util.List;

import employee.Employee;
import employee.UserNotFoundException;

public interface EmployeeService {
    Employee getUserById(long employee_id) throws UserNotFoundException;

    List<Employee> getAllUsers();

    Employee updateUser(long employee_id, Employee employee) throws UserNotFoundException;

    Employee saveUser(Employee employee);

    void deleteUser(long employee_id) throws UserNotFoundException;

}
