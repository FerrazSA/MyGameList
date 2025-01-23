package com.centsa.mygamelist.controllers;

import com.centsa.mygamelist.dto.GameListDTO;
import com.centsa.mygamelist.dto.GameMinDTO;
import com.centsa.mygamelist.dto.ReplacementDTO;
import com.centsa.mygamelist.services.GameListService;
import com.centsa.mygamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.Move(listId, body.souceIndex(), body.destinationIndex() );
    }
}
