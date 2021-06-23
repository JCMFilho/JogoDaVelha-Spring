package com.jogo.tictactoe.service;

import com.jogo.tictactoe.dto.GameInput;
import com.jogo.tictactoe.dto.GameOutput;

public interface GameService {

	GameOutput createGame(GameInput game);
	
}
