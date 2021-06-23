package com.jogo.tictactoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jogo.tictactoe.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
	@Query("Select g from Game g where g.id = :gameId")
	public Game getGame(@Param("gameId") Long gameId);
}
