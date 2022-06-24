package me.kwanghee.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import me.kwanghee.board.model.Board;

public interface JpaBoardRepository extends JpaRepository<Board, Long> {

}
