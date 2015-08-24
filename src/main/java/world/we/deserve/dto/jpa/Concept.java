package world.we.deserve.dto.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the concept database table.
 * 
 */
@Entity
@Table(name="concept")
@NamedQuery(name="Concept.findAll", query="SELECT c FROM Concept c")
public class Concept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int concept_Id;

	@Column(name="abstract")
	private String abstract_;

	private byte[] good;

	private String resume;

	//bi-directional many-to-many association to Nihilist
	@ManyToMany(mappedBy="concepts")
	private List<Nihilist> nihilists;

	public Concept() {
	}

	public int getConcept_Id() {
		return this.concept_Id;
	}

	public void setConcept_Id(int concept_Id) {
		this.concept_Id = concept_Id;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public byte[] getGood() {
		return this.good;
	}

	public void setGood(byte[] good) {
		this.good = good;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public List<Nihilist> getNihilists() {
		return this.nihilists;
	}

	public void setNihilists(List<Nihilist> nihilists) {
		this.nihilists = nihilists;
	}

}