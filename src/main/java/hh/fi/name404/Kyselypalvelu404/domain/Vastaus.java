package hh.fi.name404.Kyselypalvelu404.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausid;
	private String vastaus;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="kysymysid")
	@NotNull
	private Kysymys kysymys;

	public Vastaus() {

	}
	
	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastaus = vastaus;
		this.kysymys = kysymys;
	}

	public Vastaus(Long vastausid, String vastaus, Kysymys kysymys) {
		super();
		this.vastausid = vastausid;
		this.vastaus = vastaus;
		this.kysymys = kysymys;
	}

	public Long getVastausid() {
		return vastausid;
	}

	public void setVastausid(Long vastausid) {
		this.vastausid = vastausid;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	



	
	
}
