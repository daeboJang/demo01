package me.kwanghee.board.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "board")
@Getter
@Builder
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String content;
	private String writer;
	private Integer readCount;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime createdAt;
	
	@DateTimeFormat(pattern = "YYYY-mm-dd HH:ii:ss")
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void setupDateTime() {
		this.readCount = 0;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = this.createdAt;
	}
}
