package com.epe.jpa.domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class Item extends MetaData {

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Long pricce;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPricce() {
		return pricce;
	}

	public void setPricce(Long pricce) {
		this.pricce = pricce;
	}
	
}
