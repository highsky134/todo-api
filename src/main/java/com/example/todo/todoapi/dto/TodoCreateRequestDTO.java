package com.example.todo.todoapi.dto;

import com.example.todo.todoapi.entity.Todo;
import com.example.todo.userapi.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TodoCreateRequestDTO {

    @NotBlank
    @Size(min = 2, max = 10)
    private String title;

    // dto를 엔터티로 변환
    public Todo toEntity() {
        return Todo.builder()
                .title(this.title)
                .build();
    }

    // 오버로딩
    public Todo toEntity(User user) {
        return Todo.builder()
                .user(user)
                .title(this.title)
                .build();
    }
}
