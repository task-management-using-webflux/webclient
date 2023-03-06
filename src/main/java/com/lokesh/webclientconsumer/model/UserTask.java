package com.lokesh.webclientconsumer.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTask {
//    private String id;
//    private String name;
//    private String emailId;
//    private String taskId;
    private User user;
    private Task task;

}
