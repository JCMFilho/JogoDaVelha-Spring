package com.jogo.tictactoe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogo.tictactoe.dto.GameInput;
import com.jogo.tictactoe.dto.GameOutput;
import com.jogo.tictactoe.dto.MovementInput;
import com.jogo.tictactoe.dto.MovementOutput;
import com.jogo.tictactoe.service.GameService;
import com.jogo.tictactoe.service.MovementsService;

@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController {
	
	private final GameService gameService;
	private final MovementsService movementsService;
	
	public GameController(GameService gameService,MovementsService movementsService) {
		this.gameService = gameService;
		this.movementsService = movementsService;
	}
	
	@PostMapping
	public ResponseEntity<GameOutput> createGame(@RequestBody GameInput game){
		return ResponseEntity.ok(this.gameService.createGame(game));
	}

	
	@PostMapping("/{id}/movement")
	public ResponseEntity<?> playGame(@PathVariable("id") Long id, @RequestBody MovementInput movement){
		return ResponseEntity.ok(this.movementsService.makeMovement(movement,id));
		
	}
}
