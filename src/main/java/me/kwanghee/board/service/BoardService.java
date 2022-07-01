package me.kwanghee.board.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kwanghee.board.model.Board;
import me.kwanghee.board.persistence.JpaBoardRepository;

@Service
public class BoardService {

	private final JpaBoardRepository boardRepository;
	
	@Autowired
	public BoardService(JpaBoardRepository boardRepository) {
		
		this.boardRepository = boardRepository;
	}
	
	// 게시글 등록
	public Board register(Board board) {
		
		
		return null;
	}
	
	// 게시글 리스트 불러오기
	public List<Board> getList() {
		
		List<Board> result = boardRepository.findAll();
		return result;
	}
	
	// 게시글 1개 얻기 
	public Board read(Long id) {
		
		// Optional 을 사용하여 null 이면 예외 발생
		// 있으면 엔티티 반환
		Board result = this.boardRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시물 입니다."));
		
		return result;
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
