package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAVE")
public class Cave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6077375906710927047L;

	public Cave(String name, int maxBears) {
		super();
		this.name = name;
		this.maxBears = maxBears;
	}

	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caveSequence")
	@SequenceGenerator(allocationSize = 25, name = "caveSequence", sequenceName = "SQ_CAVE_PK")
	@Column(name = "CAVE_ID")
	private int id;
	@Column(name = "CAVE_NAME")
	private String name;
	@Column(name = "MAX_BEARS")
	private int maxBears;

	// bidirectional mapping, lazily fetched
	@OneToMany(mappedBy = "cave", fetch = FetchType.LAZY)
	private List<Bear> bears;

	public List<Bear> getBears() {
		return bears;
	}

	public Cave() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxBears() {
		return maxBears;
	}

	public void setMaxBears(int maxBears) {
		this.maxBears = maxBears;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", maxBears=" + maxBears + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + maxBears;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cave other = (Cave) obj;
		if (id != other.id)
			return false;
		if (maxBears != other.maxBears)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
