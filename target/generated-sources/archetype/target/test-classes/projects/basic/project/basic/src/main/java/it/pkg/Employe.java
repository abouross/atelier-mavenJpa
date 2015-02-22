package it.pkg;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employe {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Adresse adresse;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Projet> projets;

	public Employe() {}

	public Employe(String name, Department department) {
		this.name = name;
		this.department = department;
	}
	

	public Employe(String name) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Employé [id=" + id + ", nom=" + name + ", department="
				+ department.getName() + ", adresse="+adresse+" ]";
	}

}
