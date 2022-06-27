package me.kwanghee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.kwanghee.board.model.Board;
import me.kwanghee.persistence.JpaBoardRepository;

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
				// ����, ����, �ۼ���
//				repo.save(new Board("����1", "�Խñ� ������...1", "ȫ�浿", 0));
//				repo.save(new Board("����2", "�Խñ� ������...2", "ȫ�浿", 0));
//				repo.save(new Board("����3", "�Խñ� ������...3", "ȫ���", 0));
//				repo.save(new Board("����4", "�Խñ� ������...4", "ȫ�浿", 0));
//				repo.save(new Board("����5", "�Խñ� ������...5", "��游", 0));
				
				// builder ����ؼ� �ʱ� ������ ����
				for (int i=1; i <= 100; i++)
				{
				repo.save(Board.builder().title("����" + i)
						.content("�Խñ� ������..." + i)
						.writer("ȫ�浿")
						.build());
				} // for()
			}
		};
	}

}
