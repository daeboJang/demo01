package me.kwanghee.board.service;

import static org.assertj.core.api.Assertions.assertThat;

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

}
