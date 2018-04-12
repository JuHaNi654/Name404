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

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysid;
	
	private String kysymys;
	
	private String tyyppi;
	
	@ManyToOne
	@JoinColumn(name="kysymykset")
	private Kysely kysely;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;
	
	public Kysymys() {

	}

	public Kysymys(Long kysymysid, String kysymys, String tyyppi, Kysely kysely, List<Vastaus> vastaukset) {
		super();
		this.kysymysid = kysymysid;
		this.kysymys = kysymys;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
		this.vastaukset = vastaukset;
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

	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + ", tyyppi=" + tyyppi + "]";
	}

	
	
}
