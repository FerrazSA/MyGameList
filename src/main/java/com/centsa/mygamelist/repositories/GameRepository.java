package com.centsa.mygamelist.repositories;

import com.centsa.mygamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
