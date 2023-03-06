package com.lokesh.webclientconsumer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private String taskId;
    @Field("task_title")
    private String title;
    @Field("task_desc")
    private List<String> description;
    @Field("task_completed")
    private boolean completed;
    @Indexed
    @DBRef
    @Field("email_id")
    private String emailId;
}
