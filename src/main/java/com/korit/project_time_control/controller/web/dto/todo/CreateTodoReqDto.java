package com.korit.project_time_control.controller.web.dto.todo;

import lombok.Data;

@Data
public class CreateTodoReqDto {
	private boolean importance;
	private String todo;
}
