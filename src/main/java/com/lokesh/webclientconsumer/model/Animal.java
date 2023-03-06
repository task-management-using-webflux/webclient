package com.lokesh.webclientconsumer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    private String id;

    private String name;

    private String kingdom;
}

