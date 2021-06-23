package com.jogo.tictactoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jogo.tictactoe.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>{

}
