package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter // аннотации из ломбока, для сокращения кода
@Setter
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String passwordHint;
}
