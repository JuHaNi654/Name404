package hh.fi.name404.Kyselypalvelu404.domain;

public class Kysymys {
	private Long id;
	private String teksti;
	
	public Kysymys() {
		
	}

	public Kysymys(Long id, String teksti) {
		super();
		this.id = id;
		this.teksti = teksti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	@Override
	public String toString() {
		return "Kysymys [id=" + id + ", teksti=" + teksti + "]";
	}
}
