package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String passwordHint;
    private boolean checkBox1;
    private boolean checkBox2;
}
