package com.kelimeoyunu.controller;

import com.kelimeoyunu.dto.AddPointsToPlayer;
import com.kelimeoyunu.dto.PlayerResponse;
import com.kelimeoyunu.dto.SavePlayerRequest;
import com.kelimeoyunu.model.Player;
import com.kelimeoyunu.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id){
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> savePlayer(@RequestBody SavePlayerRequest request){
        return ResponseEntity.ok(playerService.savePlayer(request));
    }

    @PostMapping("/addPoints")
    public ResponseEntity<PlayerResponse> addPointsToPlayer(@RequestBody AddPointsToPlayer request){
        return ResponseEntity.ok(playerService.addPointsToPlayer(request));
    }
}
