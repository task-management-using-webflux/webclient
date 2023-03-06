package com.lokesh.webclientconsumer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Field("user_name")
    private String name;
    @Indexed(unique = true)
    @Field("email_id")
    private String emailId;

//    private Task task;
}
