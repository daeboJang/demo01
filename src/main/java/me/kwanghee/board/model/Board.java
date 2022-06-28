package me.kwanghee.board.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private final String title;
	private final String content;
	private final String writer;
	@Builder.Default private Integer readCount = 0;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime createdAt;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void setupDateTime() {
		// final 필드는 생성자 에서만 초기화 할 수 있음
		//this.readCount = 0;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = this.createdAt;
	}
}


