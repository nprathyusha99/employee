package employee;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name="first_name", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String firstName;

    @Column(name="last_name", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String lastName;

    @OneToOne
    
    @Column(name="department_id", nullable = false)
    private int departmentId;

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
