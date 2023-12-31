package com.rahulsharma.virtulibrarian.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 10001, allocationSize = 1)
    @JsonIgnore
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonIgnore
    private String role;
}
