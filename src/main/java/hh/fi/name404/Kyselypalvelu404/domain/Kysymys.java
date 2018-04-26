package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysid;
	
	private String kysymys;
	
	private String tyyppi;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="kyselyid")
	private Kysely kysely;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vaihtoehto> vaihtoehdot;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;

	public Kysymys() {
		super();
	}

	public Kysymys(Long kysymysid, String kysymys, String tyyppi, Kysely kysely) {
		super();
		this.kysymysid = kysymysid;
		this.kysymys = kysymys;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
	}
	
	
	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

	public Long getKysymysid() {
		return kysymysid;
	}

	public void setKysymysid(Long kysymysid) {
		this.kysymysid = kysymysid;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	
}
