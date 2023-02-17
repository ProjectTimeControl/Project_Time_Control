package com.korit.project_time_control.service.todo;

import org.springframework.stereotype.Service;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		System.out.println(createTodoReqDto);
		if(1==1) {
			throw new RuntimeException();
		}
		return false;
	}

}

