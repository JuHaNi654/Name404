package hh.fi.name404.Kyselypalvelu404.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vastaus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vastausid;
	private String sisalto;
	
	public Vastaus() {
		
	}
	
	@ManyToOne
	@JoinColumn(name = "kysymysid")
	private Kysymys kysymys;

	public Vastaus(Long vastausid, String sisalto) {
		super();
		this.vastausid = vastausid;
		this.sisalto = sisalto;
	}

	public Long getVastausid() {
		return vastausid;
	}

	public void setVastausid(Long vastausid) {
		this.vastausid = vastausid;
	}

	public String getSisalto() {
		return sisalto;
	}

	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausid=" + vastausid + ", sisalto=" + sisalto + "]";
	}
	
}
