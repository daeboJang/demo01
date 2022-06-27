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
	
	// �Խñ� ���
	public Board register() {
		return null;
	}
	
	// �Խñ� ����Ʈ �ҷ�����
	public List<Board> getList() {
		
		List<Board> result = boardRepository.findAll();
		return result;
	}
	
	// �Խñ� 1�� ��� 
	public Board read(Long id) {
		Optional<Board> result;
		result = this.boardRepository.findById(id);
		
		return result.get();
	}
	
	// �Խñ� �˻� ����Ʈ
	public List<Board> serach() {
		return null;
	}
	
	// �Խñ� ����
	public void update(Long id) {
		
	}
	
	// �Խñ� ����
	public void delete(Long id) {
		
	}
	
}
