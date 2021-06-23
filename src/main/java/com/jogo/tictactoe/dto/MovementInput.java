package com.jogo.tictactoe.dto;

public class MovementInput {

	private String player;
	
	private Position position;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
