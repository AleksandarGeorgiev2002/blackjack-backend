package com.CardGameBlackJack.repository;

import com.CardGameBlackJack.model.GameHistory;
import com.CardGameBlackJack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameHistoryRepository extends JpaRepository<GameHistory, Long> {
    List<GameHistory> findTop10ByUserOrderByGameEndTimeDesc(User user);
}
