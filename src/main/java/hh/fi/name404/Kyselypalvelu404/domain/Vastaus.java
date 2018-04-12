package hh.fi.name404.Kyselypalvelu404.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vastaus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausid;
	private String vastaus;
	
	public Vastaus() {
		
	}
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "kysymysid")
	private Kysymys kysymys;

	public Vastaus(Long vastausid, String vastaus) {
		super();
		this.vastausid = vastausid;
		this.vastaus = vastaus;
	}

	public Long getVastausid() {
		return vastausid;
	}

	public void setVastausid(Long vastausid) {
		this.vastausid = vastausid;
	}

	public String getvastaus() {
		return vastaus;
	}

	public void setvastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + "]";
	}
	
}
