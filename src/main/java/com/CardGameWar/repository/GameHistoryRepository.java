package com.CardGameWar.repository;

import com.CardGameWar.model.GameHistory;
import com.CardGameWar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameHistoryRepository extends JpaRepository<GameHistory, Long> {
    List<GameHistory> findTop10ByUserOrderByGameEndTimeDesc(User user);
}
