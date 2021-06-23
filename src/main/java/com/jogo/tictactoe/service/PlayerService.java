package com.jogo.tictactoe.service;

import java.util.List;

import com.jogo.tictactoe.model.Player;

public interface PlayerService {

	List<Player> getAllPlayers();
	
	void savePlayer(Player player);
}
