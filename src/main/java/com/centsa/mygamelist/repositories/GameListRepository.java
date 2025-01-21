package com.centsa.mygamelist.repositories;

import com.centsa.mygamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
