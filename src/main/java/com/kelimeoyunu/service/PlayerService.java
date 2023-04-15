package com.kelimeoyunu.service;

import com.kelimeoyunu.dto.AddPointsToPlayer;
import com.kelimeoyunu.dto.PlayerResponse;
import com.kelimeoyunu.dto.SavePlayerRequest;
import com.kelimeoyunu.model.Player;
import com.kelimeoyunu.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(Integer id){
        Player player = playerRepository.findById(id).orElseThrow(RuntimeException::new);

        return player;
    }

    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);

        return players;
    }

    public PlayerResponse savePlayer(SavePlayerRequest request){

        Player player = Player.builder()
                .name(request.getName())
                .points(0)
                .build();

        Player fromDB = playerRepository.save(player);

        return PlayerResponse.builder()
                .id(fromDB.getId())
                .name(fromDB.getName())
                .points(fromDB.getPoints())
                .build();
    }

    public PlayerResponse addPointsToPlayer(AddPointsToPlayer request){
        Player player = getPlayerById(request.getPlayerId());

        Integer playerPoints = player.getPoints();
        playerPoints += request.getPoints();
        player.setPoints(playerPoints);

        Player fromDB = playerRepository.save(player);

        return PlayerResponse.builder()
                .name(fromDB.getName())
                .points(fromDB.getPoints())
                .build();
    }
}
