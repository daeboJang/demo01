package me.kwanghee.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.kwanghee.board.model.Board;
import me.kwanghee.board.persistence.JpaBoardRepository;

@SpringBootTest
class JpaBoardRepositoryTest {
	
	@Autowired private JpaBoardRepository repository;

	@BeforeEach
	void beforeEach() {
		
	}

	@Test
	void 초기화테스트() {
		int numRows = (int) repository.count();
		assertThat(numRows).isEqualTo(50);
	}
	
	@Test
	@DisplayName("findbyId 테스트")
	void findByIdTest() {
		Board article = repository.findById((long)50).orElseGet(null);
		assertThat(article.getTitle()).isEqualTo("제목50");
		assertThat(article.getReadCount()).isEqualTo(0);
	}
	
	@Test
	void 신규글입력() {
		Board article = repository.save(Board.builder()
				.title("신규 테스트 글")
				.content("신규 테스트 본문")
				.writer("장광희")
				.build());
		assertThat(article.getId()).isEqualTo(51);			// 신규 id
		assertThat(article.getReadCount()).isEqualTo(0);	// 조회수 
	}
	
	@Test
	void 게시글_없으면_예외발생() {
		Optional<Board> article = repository.findById(999L);
		article.ifPresent(m -> fail());
	}

}
