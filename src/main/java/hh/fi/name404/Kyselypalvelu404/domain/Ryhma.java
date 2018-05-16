package hh.fi.name404.Kyselypalvelu404.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ryhma {

	@Id
	private Long ryhmaid;
	
	@NotNull
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ryhma")
	@JsonIgnore
	private List<Kysely> kyselyt;

	public Ryhma(Long ryhmaid, String ryhmanimi, List<Kysely> kyselyt) {
		super();
		this.ryhmaid = ryhmaid;
		this.nimi = ryhmanimi;
		this.kyselyt = kyselyt;
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

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Kysely> getKyselyt() {
		return kyselyt;
	}

	public void setKyselyt(List<Kysely> kyselyt) {
		this.kyselyt = kyselyt;
	}
	
	
}
