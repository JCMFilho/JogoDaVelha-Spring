package com.jogo.tictactoe.service;

import com.jogo.tictactoe.dto.MovementInput;
import com.jogo.tictactoe.dto.MovementOutput;

public interface MovementsService {
	Object makeMovement(MovementInput movement, Long id);

}
