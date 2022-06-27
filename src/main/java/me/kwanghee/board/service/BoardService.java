package me.kwanghee.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kwanghee.board.model.Board;
import me.kwanghee.persistence.JpaBoardRepository;

@Service
public class BoardService {

	private final JpaBoardRepository boardRepository;
	
	@Autowired
	public BoardService(JpaBoardRepository boardRepository) {
		
		this.boardRepository = boardRepository;
	}
	
	// 게시글 등록
	public Board register() {
		return null;
	}
	
	// 게시글 리스트 불러오기
	public List<Board> getList() {
		
		List<Board> result = boardRepository.findAll();
		return result;
	}
	
	// 게시글 1개 얻기 
	public Board read(Long id) {
		Optional<Board> result;
		result = this.boardRepository.findById(id);
		
		return result.get();
	}
	
	// 게시글 검색 리스트
	public List<Board> serach() {
		return null;
	}
	
	// 게시글 수정
	public void update(Long id) {
		
	}
	
	// 게시글 삭제
	public void delete(Long id) {
		
	}
	
}
