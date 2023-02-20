package com.korit.project_time_control.service.todo;

import org.springframework.stereotype.Service;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.domain.todo.Todo;
import com.korit.project_time_control.domain.todo.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	
	private final TodoRepository todoRepository;
	
	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.toEntity();
		return todoRepository.save(todoEntity) > 0;
	}

}

