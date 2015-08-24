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
	private int nihilistId;

	private int rage;

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

	public int getNihilistId() {
		return this.nihilistId;
	}

	public void setNihilistId(int nihilistId) {
		this.nihilistId = nihilistId;
	}

	public int getRage() {
		return this.rage;
	}

	public void setRage(int rage) {
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