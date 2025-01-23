package com.centsa.mygamelist.services;

import com.centsa.mygamelist.dto.GameListDTO;
import com.centsa.mygamelist.projections.GameMinProjection;
import com.centsa.mygamelist.repositories.GameListRepository;
import com.centsa.mygamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        var result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void Move(Long listId, int souceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(souceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(souceIndex, destinationIndex);
        int max = Math.max(souceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
