package com.jogo.tictactoe.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jogo.tictactoe.model.Player;
import com.jogo.tictactoe.repository.PlayerRepository;
import com.jogo.tictactoe.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;
	
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return playerRepository.findAll();
	}

	
	public void savePlayer(Player player) {
		player.setLosses(0);
		player.setWins(0);
		playerRepository.save(player);
	}

}
