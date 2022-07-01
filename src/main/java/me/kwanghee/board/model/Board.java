package me.kwanghee.board.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
import lombok.Setter;

@Entity
@Table(name = "board")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Board {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private Long id;					// 못 바꿈
	
	private String title;
	
	private String content;
	
	@Column(nullable = false)
	private String writer;		// 못 바꿈
	
	private Integer readCount = 0;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime createdAt;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime updatedAt;
	
	@Builder
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		
		this.createdAt = LocalDateTime.now();
	}
	
	@PrePersist
	public void setupDateTime() {
		// 실제 저장 전 갱신 시간만 자동 업데이트
		this.updatedAt = LocalDateTime.now();
	}
}


