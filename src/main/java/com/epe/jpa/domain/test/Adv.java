package com.epe.jpa.domain.test;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADV")
public class Adv {

	@Id
	@Column(name = "ADV_ID")
	@GeneratedValue
	private Long id;
	
	private String name;

	@Embedded
	private Period period;
	
	@Embedded
	private Address homePeriod;
	
	@Embedded
	@AttributeOverrides({
		 @AttributeOverride(name="city", 
				 column=@Column(name = "WORK_CITY")),
		 @AttributeOverride(name="street", 
		 		column=@Column(name = "WORK_STREET")),
		 @AttributeOverride(name="zipcode", 
	 		column=@Column(name = "WORK_ZIPCODE"))
		 })
	private Address workPeriod;
	
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}


	public Address getHomePeriod() {
		return homePeriod;
	}

	public void setHomePeriod(Address homePeriod) {
		this.homePeriod = homePeriod;
	}

	public Address getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Address workPeriod) {
		this.workPeriod = workPeriod;
	}

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
	
	
}
