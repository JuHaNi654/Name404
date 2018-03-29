package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ryhma {

	@Id
	private Long ryhmaid;
	
	private String ryhmanimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ryhma")
	private List<Kysymys> kysymykset;

	public Ryhma(Long ryhmaid, String ryhmanimi, List<Kysymys> kysymykset) {
		super();
		this.ryhmaid = ryhmaid;
		this.ryhmanimi = ryhmanimi;
		this.kysymykset = kysymykset;
	}

	public Ryhma() {
		super();
	}

	public Long getRyhmaid() {
		return ryhmaid;
	}

	public void setRyhmaid(Long ryhmaid) {
		this.ryhmaid = ryhmaid;
	}

	public String getRyhmanimi() {
		return ryhmanimi;
	}

	public void setRyhmanimi(String ryhmanimi) {
		this.ryhmanimi = ryhmanimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	
	
}
