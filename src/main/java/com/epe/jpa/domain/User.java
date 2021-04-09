package com.epe.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "userName") //-> dto명칭과 컬럼 명칭이 다른경우에 선언
	private String userName;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public void changeTeam(Team team) {
		this.team = team;
		team.getUsers().add(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
	
}
