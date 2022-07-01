package me.kwanghee.board.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * DTO 는 레이어간 데이타 전달 기능만 가지는 가변 객체임
 * Entity <-> DTO 간 변환
 * 자체 로직을 가지면 안됨!!!
 */
@Data
public class BoardDTO {
	
	@Setter(AccessLevel.NONE)
	private int id;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private int readCount = 0;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime createdAt;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime updatedAt;
}
