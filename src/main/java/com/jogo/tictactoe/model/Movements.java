package com.jogo.tictactoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movements")
public class Movements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@JoinColumn(name = "IDGAME", referencedColumnName = "ID", nullable = false)
	@ManyToOne
	private Game idGame;

	@Column(name = "XCOORDINATE", nullable = false)
	private Integer xCoordinate;

	@Column(name = "YCOORDINATE", nullable = false)
	private Integer yCoordinate;

	@Column(name = "PLAYER", length = 2, nullable = false)
	private String player;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getIdGame() {
		return idGame;
	}

	public void setIdGame(Game idGame) {
		this.idGame = idGame;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}
