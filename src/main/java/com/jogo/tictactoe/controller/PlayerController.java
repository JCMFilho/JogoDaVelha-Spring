package com.jogo.tictactoe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogo.tictactoe.model.Player;
import com.jogo.tictactoe.service.PlayerService;


@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {
	
	private final PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers(){
		return ResponseEntity.ok(this.playerService.getAllPlayers());
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> savePlayer(@RequestBody Player player){
		this.playerService.savePlayer(player);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
