package hh.fi.name404.Kyselypalvelu404.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Vaihtoehto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vaihtoehtoid;
	
	@NotNull
	private String vaihtoehto;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="kysymysid")
	@NotNull
	private Kysymys kysymys;
	
	public Vaihtoehto() {
		super();
	}

	public Vaihtoehto(Long vaihtoehtoid, String vaihtoehto, Kysymys kysymys) {
		super();
		this.vaihtoehtoid = vaihtoehtoid;
		this.vaihtoehto = vaihtoehto;
		this.kysymys = kysymys;
	}

	public Long getVaihtoehtoid() {
		return vaihtoehtoid;
	}

	public void setVaihtoehtoid(Long vaihtoehtoid) {
		this.vaihtoehtoid = vaihtoehtoid;
	}

	public String getVaihtoehto() {
		return vaihtoehto;
	}

	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	
}
