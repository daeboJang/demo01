package me.kwanghee.board.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.kwanghee.board.model.Board;

@SpringBootTest
class BoardServiceTest {
	
	@Autowired private BoardService boardService;
	
	@BeforeEach
	void setup() {
		// SpringBoot 시작시 테스트용 초기 데이터 100개 삽입됨
		// CommandLineRunner 사용
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		Board article = boardService.read((long) 1);
		assertThat(article.getId()).isEqualTo(1);
	}
	
	@Test
	void 게시글_없으면_예외발생() {
		//given
		
		//when
		Exception e = assertThrows(NoSuchElementException.class,() -> boardService.read(999L));
		
		//then
		assertThat(e.getMessage()).isEqualTo("존재하지 않는 게시물 입니다.");
	}

}
