package hh.fi.name404.Kyselypalvelu404.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ryhmaid")
	private Ryhma ryhma;
	
	private String kysymys;
	
	public Kysymys() {
		
	}
	
	public Kysymys(String kysymys) {
		super();
		this.kysymys = kysymys;
	}

	public Kysymys(Long id, String kysymys) {
		super();
		this.id = id;
		this.kysymys = kysymys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + "]";
	}
}
