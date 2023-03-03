package com.korit.project_time_control.service.todo;

import java.util.List;
import java.util.Map;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.controller.web.dto.todo.TodoListRespDto;
import com.korit.project_time_control.controller.web.dto.todo.UpdateTodoReqDto;
import com.korit.project_time_control.domain.todo.Todo;

public interface TodoService {
	
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	
	public List<TodoListRespDto> getTodoList(String type, int page, int contentCount) throws Exception;
	
	public boolean updateTodoComplete(int todoCode) throws Exception;
	public boolean updateTodoImportance(int todoCode) throws Exception;
	public boolean updateTodo(UpdateTodoReqDto updateTodoReqDto) throws Exception;
	
	
	public boolean removeTodo(int todoCode) throws Exception;
}
	
	