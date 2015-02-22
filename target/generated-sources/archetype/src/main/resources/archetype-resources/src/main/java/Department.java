#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
	private List<Employe> employees = new ArrayList<Employe>();
	
	
	public Department() {
		super();
	}
	public Department(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employe> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}
}
