package com.korit.project_time_control.controller.web.dto.todo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoListRespDto {
	private int todoCode;
	private String todo;
	private boolean todoComplete;
	private boolean importance;
	private int total_count;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
	
}
