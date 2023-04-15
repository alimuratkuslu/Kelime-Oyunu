package com.kelimeoyunu.repository;

import com.kelimeoyunu.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
