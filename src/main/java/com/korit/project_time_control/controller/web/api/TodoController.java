package com.korit.project_time_control.controller.web.api;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.korit.project_time_control.controller.web.dto.CMRespDto;
import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.controller.web.dto.todo.TodoListRespDto;
import com.korit.project_time_control.service.todo.TodoService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getTodoList(@RequestParam int page) {
		List<TodoListRespDto> list = null;
		try {
			list = todoService.getTodoList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, page + "page load failure", list));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, page + "page load success", list));
		
	}
	
	@PostMapping("/todo") 
	public ResponseEntity<?> addTodo(@RequestBody CreateTodoReqDto createtodoreqdto) {
		try {
			if(!todoService.createTodo(createtodoreqdto)){
				throw new RuntimeException("DB Error");  //실행중 오류는 RuntimeException으로 잡기
			}
		} catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failure", createtodoreqdto));
		}
		 return ResponseEntity.ok().body(new CMRespDto<>(1, "success", createtodoreqdto));
	 }
}
