package com.jogo.tictactoe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jogo.tictactoe.model.Movements;

@Repository
public interface MovementsRepository extends JpaRepository<Movements,Long> {
	@Query("Select m from Movements m where m.idGame.id = :gameId ")
	public List<Movements> getAllMovementsByGame(@Param("gameId") Long gameId);
	
	@Query("Select m from Movements m where m.idGame.id =:gameId and m.yCoordinate =:y and m.xCoordinate =:x")
	public Movements checkIfAMovementWasMadeBefore(@Param("gameId") Long gameId, @Param("y") Integer integer, @Param("x") Integer integer2);
}
