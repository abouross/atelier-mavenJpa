#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue
	private Long id;

	private String adresse;
	
	public Adresse() {
		super();
	}

	public Adresse(String adresse) {
		super();
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "" + adresse;
	}
	
	
}
