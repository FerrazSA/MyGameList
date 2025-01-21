package com.centsa.mygamelist.controllers;

import com.centsa.mygamelist.dto.GameDTO;
import com.centsa.mygamelist.dto.GameMinDTO;
import com.centsa.mygamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.fingById(id);
    }
}
