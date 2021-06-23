package com.jogo.tictactoe.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jogo.tictactoe.dto.MovementInput;
import com.jogo.tictactoe.dto.MovementOutput;
import com.jogo.tictactoe.model.Game;
import com.jogo.tictactoe.model.Movements;
import com.jogo.tictactoe.model.Player;
import com.jogo.tictactoe.repository.GameRepository;
import com.jogo.tictactoe.repository.MovementsRepository;
import com.jogo.tictactoe.repository.PlayerRepository;
import com.jogo.tictactoe.service.MovementsService;

@Service
public class MovementsServiceImpl implements MovementsService {

	private final GameRepository gameRepository;
	private final MovementsRepository movementsRepository;
	private final PlayerRepository playerRepository;
	
	public MovementsServiceImpl(GameRepository gameRepository,MovementsRepository movementsRepository,PlayerRepository playerRepository) {
		this.gameRepository = gameRepository;
		this.movementsRepository = movementsRepository;
		this.playerRepository = playerRepository;
	}
	
	@Override
	public Object makeMovement(MovementInput movement, Long id) {
		
		MovementOutput output = new MovementOutput();
		Movements movementToSave = new Movements();
		if(!this.gameRepository.existsById(id)) {
			output.setMsg("Partida não encontrada");
			return output;
		}
		Game game = this.gameRepository.getGame(id);
		if(!game.getCurrentPlayer().equals(movement.getPlayer())) {
			output.setMsg("Não é turno do jogador");
			return output;
		}
		Movements mov = this.movementsRepository.checkIfAMovementWasMadeBefore(id, movement.getPosition().getY(), movement.getPosition().getX());
		if(mov != null) {
			output.setMsg("Jogada já realizada.");
			return output;
		}
		List<Movements> movements = this.movementsRepository.getAllMovementsByGame(id);
		if(movements.size() < 4) {
			movementToSave.setIdGame(game);
			movementToSave.setPlayer(movement.getPlayer());
			movementToSave.setxCoordinate(movement.getPosition().getX());
			movementToSave.setyCoordinate(movement.getPosition().getY());
			this.movementsRepository.saveAndFlush(movementToSave);
			if(game.getCurrentPlayer().equals("X")) {
				game.setCurrentPlayer("Y");
			}else {
				game.setCurrentPlayer("X");
			}
			this.gameRepository.saveAndFlush(game);
			return HttpStatus.OK;
		}
		movementToSave.setIdGame(game);
		movementToSave.setPlayer(movement.getPlayer());
		movementToSave.setxCoordinate(movement.getPosition().getX());
		movementToSave.setyCoordinate(movement.getPosition().getY());
		movementToSave = this.movementsRepository.saveAndFlush(movementToSave);
		movements.add(movementToSave);
		
		if(game.getCurrentPlayer().equals("X")) {
			game.setCurrentPlayer("Y");
		}else {
			game.setCurrentPlayer("X");
		}
		this.gameRepository.saveAndFlush(game);
		String jogadas[][] = new String[3][3];
		
		for(Integer i = 0; i < movements.size() ; i++) {
			jogadas[movements.get(i).getxCoordinate()][movements.get(i).getyCoordinate()] = movements.get(i).getPlayer();
		}
		
		String evalVictory = evaluateVictory(jogadas);
		
		if(evalVictory.equals("D") && movements.size() == 9) {
			output.setMsg("Partida finalizada");
			output.setWinner("Draw");
			return output;
		}
		if(evalVictory.equals("X")) {
			
			Player firstPlayer = game.getFirstPlayer();
			firstPlayer.setWins(firstPlayer.getWins()+1);
			
			Player secondPlayer = game.getSecondPlayer();
			secondPlayer.setWins(secondPlayer.getLosses()+1);
			
			this.playerRepository.saveAndFlush(firstPlayer);
			this.playerRepository.saveAndFlush(secondPlayer);
			
			output.setMsg("Partida finalizada");
			output.setWinner(game.getFirstPlayer().getName());
			return output;
		}
		if(evalVictory.equals("Y")) {
			
			Player firstPlayer = game.getFirstPlayer();
			firstPlayer.setWins(firstPlayer.getLosses()+1);
			
			Player secondPlayer = game.getSecondPlayer();
			secondPlayer.setWins(secondPlayer.getWins()+1);
			
			this.playerRepository.saveAndFlush(firstPlayer);
			this.playerRepository.saveAndFlush(secondPlayer);
			output.setMsg("Partida finalizada");
			output.setWinner(game.getSecondPlayer().getName());
			return output;
		}
		
		
		return HttpStatus.OK;
	}
	
	private String evaluateVictory(String jogadas[][]) {
		//linhas
		for(int i = 0; i < 3; i++) {
			if(jogadas[i][0] != null &&  jogadas[i][1] != null && jogadas[i][2] != null && jogadas[i][0].equals(jogadas[i][1]) && jogadas[i][0].equals(jogadas[i][2])) {
				return jogadas[i][0];
			}
			if(jogadas[0][i] != null &&  jogadas[1][i] != null && jogadas[2][i] != null && jogadas[0][i].equals(jogadas[1][i]) && jogadas[0][i].equals(jogadas[2][i])) {
				return jogadas[0][i];
			}
		}
		//diagonal
		if(jogadas[0][0] != null &&  jogadas[1][1] != null && jogadas[2][2] != null && jogadas[2][2].equals(jogadas[1][1]) && jogadas[0][0].equals(jogadas[2][2])) {
			return jogadas[0][0];
		}
		if(jogadas[0][2] != null &&  jogadas[1][1] != null && jogadas[2][0] != null && jogadas[0][2].equals(jogadas[1][1]) && jogadas[0][2].equals(jogadas[2][0])) {
			return jogadas[0][2];
		}
		
		return "D";
		
	}
	
}
