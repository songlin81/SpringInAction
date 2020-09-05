package com.example.demo.entity;

import com.example.demo.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class User {

    private Long id;

    @NotBlank(message = "Name should not be blank")
    @Length(min = 5, max = 20, message = "length 5-20 letters")
    private String name;

    @NotNull(message = "Age cannot be blank")
    @Min(value = 18, message = "min 18")
    @Max(value = 60, message = "max 60")
    private Integer age;

    @Email(message = "Please enter mailbox")
    @NotBlank(message = "mailbox should not be blank")
    private String email;

    @MyConstraint
    private String answer;
}
