package com.korit.project_time_control.service.todo;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;

public interface TodoService {
	
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	
	
	
}
	
	