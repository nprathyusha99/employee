package empService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import empRepository.EmployeeRepository;
import employee.Employee;

import employee.UserNotFoundException;

import empService.EmployeeService;
import java.util.List;


@ApplicationScoped
public class DefaultEmployeeService implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	
	@Inject
    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	
	   @Override
	    public Employee getUserById(long id) throws UserNotFoundException {
	        return employeeRepository.findByIdOptional(id).orElseThrow(() -> new UserNotFoundException("There user doesn't exist"));
	    }

	    @Override
	    public List<Employee> getAllUsers() {
	        return employeeRepository.listAll();
	    }

	    @Transactional
	    @Override
	    public Employee updateUser(long id, Employee employee) throws UserNotFoundException {
	    	Employee existingUser = getUserById(id);
	        existingUser.setFirstName(employee.getFirstName());
	        existingUser.setLastName(employee.getLastName());
	        existingUser.setDepartmentId(employee.getDepartmentId());
	        employeeRepository.persist(existingUser);
	        return existingUser;
	    }

	    @Transactional
	    @Override
	    public Employee saveUser(Employee employee) {
	    	employeeRepository.persistAndFlush(employee);
	        return employee;
	    }

	    @Transactional
	    @Override
	    public void deleteUser(long id) throws UserNotFoundException {
	    	employeeRepository.delete(getUserById(id));
	    }

}
