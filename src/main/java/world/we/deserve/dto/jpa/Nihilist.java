package world.we.deserve.dto.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nihilist database table.
 * 
 */
@Entity
@Table(name="nihilist")
@NamedQuery(name="Nihilist.findAll", query="SELECT n FROM Nihilist n")
public class Nihilist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nihilist_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nihilistId;

	private Integer rage;

	private String username;

	//bi-directional many-to-many association to Concept
	@ManyToMany
	@JoinTable(
		name="nihilist_concept"
		, joinColumns={
			@JoinColumn(name="nihilist_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="concept_id")
			}
		)
	private List<Concept> concepts;

	public Nihilist() {
	}

	public Integer getNihilistId() {
		return this.nihilistId;
	}

	public void setNihilistId(Integer nihilistId) {
		this.nihilistId = nihilistId;
	}

	public Integer getRage() {
		return this.rage;
	}

	public void setRage(Integer rage) {
		this.rage = rage;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

}