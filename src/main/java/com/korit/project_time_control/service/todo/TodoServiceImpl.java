package com.korit.project_time_control.service.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.controller.web.dto.todo.TodoListRespDto;
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
		String content = todoEntity.getTodo_content();
		for(int i =0; i<100; i++) {
			todoEntity.setTodo_content(content + "_" + (i+1));
			todoRepository.save(todoEntity);
			if(i % 2 == 0) {
				todoEntity.setImportance_flag(1);
			}else {
				todoEntity.setImportance_flag(0);
			}
			todoRepository.save(todoEntity);
		}
		return true;
		//return todoRepository.save(todoEntity) > 0;
	}
	
	@Override
	public List<TodoListRespDto> getTodoList(int page) throws Exception {
		
		List<Todo> todoList = todoRepository.getTodoListOfIndex((page - 1) * 20); //1 page 0 index 2 page 20 -> 점화식 (page-1) * 20 
		List<TodoListRespDto> todoListRespDtos = new ArrayList<TodoListRespDto>(); //Entity에서 dto로 builder하기 위함
		todoList.forEach(todo -> {
			todoListRespDtos.add(todo.toListDto());
		});
		return todoListRespDtos;
	}

}

