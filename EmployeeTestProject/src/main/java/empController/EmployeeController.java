package empController;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import empService.EmployeeService;
import employee.Employee;



@Path("/v1/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EmployeeController{
	private final EmployeeService employeeService;
	
    @Inject
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    public List<Employee> getUsers() {
        return employeeService.getAllUsers();
    }
	
}