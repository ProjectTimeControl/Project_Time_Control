package com.korit.project_time_control.controller.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.project_time_control.controller.web.dto.CMRespDto;
import com.korit.project_time_control.controller.web.dto.todo.CreateTodoReqDto;
import com.korit.project_time_control.service.todo.TodoService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;
	
	@PostMapping("/todo") 
	public ResponseEntity<?> addContent(@RequestBody CreateTodoReqDto createtodoreqdto) {
		try {
			todoService.createTodo(createtodoreqdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failure", createtodoreqdto));
		}
		 return ResponseEntity.ok().body(new CMRespDto<>(1, "success", createtodoreqdto));
	 }
}
