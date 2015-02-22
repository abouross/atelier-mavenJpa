#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projet {
	@Id
	@GeneratedValue
	private Long id;

	
	private String name;
	
	@ManyToMany
	private List<Employe> employees;

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

	public void addEmployee(Employe employe){
		this.employees.add(employe);
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Projet [id=" + id + ", name=" + name + ", employees : ${symbol_escape}n");
		for(Employe e:this.employees){
			result.append("${symbol_escape}t- "+e.getName()+"${symbol_escape}n");
		}
		result.append("]");
		return result.toString();
	}
	
	
}
