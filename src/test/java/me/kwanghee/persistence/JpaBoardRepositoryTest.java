package me.kwanghee.persistence;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(numRows).isEqualTo(100);
	}
	
	@Test
	@DisplayName("findbyId 테스트")
	void findByIdTest() {
		Board article = repository.findById((long)99).orElseGet(null);
		assertThat(article.getWriter()).isEqualTo("홍길동");
		assertThat(article.getTitle()).isEqualTo("제목99");
	}
	
	@Test
	void 신규글입력() {
		Board article = repository.save(Board.builder()
				.title("신규 테스트 글")
				.content("신규 테스트 본문")
				.writer("장광희")
				.build());
		assertThat(article.getId()).isEqualTo(101);			// 신규 id
		assertThat(article.getReadCount()).isEqualTo(0);	// 조회수 
		
	}

}
