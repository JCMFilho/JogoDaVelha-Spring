package com.jogo.tictactoe.service.impl;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.jogo.tictactoe.dto.GameInput;
import com.jogo.tictactoe.dto.GameOutput;
import com.jogo.tictactoe.model.Game;
import com.jogo.tictactoe.model.Player;
import com.jogo.tictactoe.repository.GameRepository;
import com.jogo.tictactoe.repository.PlayerRepository;
import com.jogo.tictactoe.service.GameService;

@Service
public class GameServiceImpl implements GameService{

	private final GameRepository gameRepository;
	private final PlayerRepository playerRepository;
	private static final Logger LOGGER = Logger.getLogger(GameService.class.getName());
	public GameServiceImpl(GameRepository gameRepository, PlayerRepository playerRepository) {
		this.gameRepository = gameRepository;
		this.playerRepository = playerRepository;
	}
	
	@Override
	public GameOutput createGame(GameInput game) {
		Game g = new Game();
		GameOutput retorno = new GameOutput();
		try {
			Random gerador = new Random();
			Player firstPlayer = this.playerRepository.getById(game.getFirstPlayer());
			Player secondPlayer = this.playerRepository.getById(game.getSecondPlayer());
		
			g.setFirstPlayer(firstPlayer);
			g.setSecondPlayer(secondPlayer);
			if(gerador.nextInt() % 2 == 0) {
				g.setCurrentPlayer("X");
			}else {
				g.setCurrentPlayer("Y");
			}
			
			g = this.gameRepository.saveAndFlush(g);
			retorno.setCurrentPlayer(g.getCurrentPlayer());
			retorno.setId(g.getId());
			retorno.setMsg("Jogo criado com sucesso");
		}catch(Exception ex) {
			retorno.setMsg("Jogador inválido");
		}
		
		return retorno;
	}

}
