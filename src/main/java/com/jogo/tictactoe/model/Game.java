package com.jogo.tictactoe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "ID", nullable = false)
	 private Long id;
	 
	 @JoinColumn(name = "FIRSTPLAYER",referencedColumnName = "ID", nullable = false)
	 @OneToOne
	 private Player firstPlayer;
	 
	 @JoinColumn(name = "SECONDPLAYER",referencedColumnName = "ID", nullable = false)
	 @OneToOne
	 private Player secondPlayer;
	 
	 @Column(name = "CURRENTPLAYER", length = 2, nullable = false)
	 private String currentPlayer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}
