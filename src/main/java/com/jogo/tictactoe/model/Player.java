package com.jogo.tictactoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class Player {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "ID", nullable = false)
	 private Long id;
	 
	 @Column(name = "NAME", length = 50, nullable = false)
	 private String name;
	 
	 @Column(name = "WINS", nullable = false)
	 private Integer wins;
	 
	 @Column(name = "LOSSES", nullable = false)
	 private Integer losses;

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

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}
	 
	 
}
