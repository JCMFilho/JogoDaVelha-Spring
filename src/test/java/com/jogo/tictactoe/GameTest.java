package com.jogo.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.jogo.tictactoe.controller.GameController;
import com.jogo.tictactoe.controller.PlayerController;
import com.jogo.tictactoe.dto.GameInput;
import com.jogo.tictactoe.dto.GameOutput;
import com.jogo.tictactoe.model.Player;

@SpringBootTest
class GameTest {

	@Autowired
	private GameController gameController;
	
	@Autowired
	private PlayerController playerController;
	
	@Test
	void givenPlayersWhenCreatingGameThenCheckIfCreated() {
		Player p1 = new Player();
		p1.setName("João");
		playerController.savePlayer(p1);
		Player p2 = new Player();
		p2.setName("Sarah");
		playerController.savePlayer(p2);
		
		ResponseEntity<List<Player>> players = playerController.getAllPlayers();
		
		GameInput g = new GameInput();
		g.setFirstPlayer(players.getBody().get(0).getId());
		g.setSecondPlayer(players.getBody().get(1).getId());
		
		ResponseEntity<GameOutput> retorno = gameController.createGame(g);
		
		assertNotNull(retorno.getBody().getId());
	}
}
