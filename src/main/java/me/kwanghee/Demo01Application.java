package me.kwanghee;

import java.util.Random;

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
				String[] people = {"홍길동", "김삿갓", "BTS", "임영웅", "아이유"};
				
				Random rand = new Random();
				
				// builder 사용해서 초기 데이터 삽입
				for (int i=1; i <= 50; i++)
				{
				repo.save(Board.builder().title("제목" + i)
						.content("게시글 내용임..." + i)
						.writer(people[rand.nextInt(5)])
						.build());
				} // for()
			}
		};
	}

}
