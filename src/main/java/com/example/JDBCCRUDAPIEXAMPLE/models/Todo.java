package com.example.JDBCCRUDAPIEXAMPLE.models;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Todo {
    private Long userId;
    private String title;
    private String description;
    private boolean done;
}

