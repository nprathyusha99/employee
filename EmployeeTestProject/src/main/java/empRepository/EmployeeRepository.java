package empRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import employee.Employee;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee>{

}
