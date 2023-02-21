package com.korit.project_time_control.service.todo;

import java.util.List;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.controller.web.dto.todo.TodoListRespDto;

public interface TodoService{
	
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	
	public List<TodoListRespDto> getTodoList(int page, int contentCount) throws Exception;
	
	
	
	
}
	
	