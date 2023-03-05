package com.korit.project_time_control.domain.todo;

import java.time.LocalDateTime;

import com.korit.project_time_control.controller.web.dto.todo.TodoListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
	private int todo_code;
	private String todo_content;
	private int todo_complete;
	private int importance_flag;
	private int total_count;
	private int incomplete_count;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public TodoListRespDto toListDto() {
		return TodoListRespDto.builder()
				.todoCode(todo_code)
				.todo(todo_content)
				.todoComplete(todo_complete == 1 ? true : false)  //todo_complete == 1 or 0 todo_complete == 1 true
				.importance(importance_flag == 1 ? true : false)  // todo_complete == 1 ? true : false
				.totalCount(total_count)
				.incompleteCount(incomplete_count)
				.createDate(create_date)
				.updateDate(update_date)
				.build();
				
				
				
	}
	
}
