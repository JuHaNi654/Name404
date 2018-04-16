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
public class Kysely {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kyselyid;
	private String nimi;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;
	
	
	@ManyToOne
	@JoinColumn(name="ryhmaid")
	private Ryhma ryhma;
	
	public Kysely() {
		super();
	}

	public Kysely(Long kyselyid, String nimi, List<Kysymys> kysymykset, Ryhma ryhma) {
		super();
		this.kyselyid = kyselyid;
		this.nimi = nimi;
		this.kysymykset = kysymykset;
		this.ryhma = ryhma;
	}

	public Kysely(String nimi, List<Kysymys> kysymykset, Ryhma ryhma) {
		super();
		this.nimi = nimi;
		this.kysymykset = kysymykset;
		this.ryhma = ryhma;
	}

	public Long getKyselyid() {
		return kyselyid;
	}

	public void setKyselyid(Long kyselyid) {
		this.kyselyid = kyselyid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	public Ryhma getRyhma() {
		return ryhma;
	}

	public void setRyhma(Ryhma ryhma) {
		this.ryhma = ryhma;
	}

	@Override
	public String toString() {
		return "Kysely [kyselyid=" + kyselyid + ", nimi=" + nimi + ", kysymykset=" + kysymykset + ", ryhma=" + ryhma
				+ "]";
	}
	
	
	

}
