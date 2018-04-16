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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kysymys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kysymysid;
	
	private String kysymys;
	
	private int tyyppi;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="kyselyid")
	private Kysely kysely;

	public Kysymys() {

	}

	public Kysymys(Long kysymysid, String kysymys, int tyyppi, Kysely kysely) {
		super();
		this.kysymysid = kysymysid;
		this.kysymys = kysymys;
		this.tyyppi = tyyppi;
		this.kysely = kysely;
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

	public int getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(int tyyppi) {
		this.tyyppi = tyyppi;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}


	@Override
	public String toString() {
		return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + ", tyyppi=" + tyyppi + "]";
	}

	
	
}
