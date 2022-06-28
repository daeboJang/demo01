package me.kwanghee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.kwanghee.board.model.Board;
import me.kwanghee.board.persistence.JpaBoardRepository;

@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(JpaBoardRepository repo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// 제목, 내용, 작성자
//				repo.save(new Board("제목1", "게시글 내용임...1", "홍길동", 0));
//				repo.save(new Board("제목2", "게시글 내용임...2", "홍길동", 0));
//				repo.save(new Board("제목3", "게시글 내용임...3", "홍길순", 0));
//				repo.save(new Board("제목4", "게시글 내용임...4", "홍길동", 0));
//				repo.save(new Board("제목5", "게시글 내용임...5", "김길만", 0));
				
				// builder 사용해서 초기 데이터 삽입
				for (int i=1; i <= 100; i++)
				{
				repo.save(Board.builder().title("제목" + i)
						.content("게시글 내용임..." + i)
						.writer("홍길동")
						.build());
				} // for()
			}
		};
	}

}
