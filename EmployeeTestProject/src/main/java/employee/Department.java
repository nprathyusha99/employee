package employee;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departments")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long department_id;
	
	@OneToOne
	Employee employee;

	public long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
}
