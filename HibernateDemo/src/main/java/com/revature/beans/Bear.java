package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries(
		{
			@NamedQuery(name="findBearByType", query="from Bear where bearType= :typeVar")
		})

@Entity
@Table(name = "BEAR")
public class Bear implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3163023788980788383L;

	public Bear(String name, Cave cave, BearType bearType, int weight) {
		super();
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
	}

	public Bear(int id, String name, Cave cave, BearType bearType, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
	}

	public Bear() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bearSequence")
	@SequenceGenerator(allocationSize = 25, name = "bearSequence", sequenceName = "SQ_BEAR_PK")
	@Column(name = "BEAR_ID")
	private int id;
	@Column(name = "BEAR_NAME")
	private String name;
	@Column(name = "WEIGHT")
	private int weight;
	// establish relationships with Cave and BearType
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CAVE_ID")
	private Cave cave;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BEAR_TYPE_ID")
	private BearType bearType;

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

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public BearType getBearType() {
		return bearType;
	}

	public void setBearType(BearType bearType) {
		this.bearType = bearType;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + ", bearType=" + bearType + ", weight=" + weight
				+ "]";
	}
}