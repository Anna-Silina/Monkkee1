package model;

public class User {
    private String email;
    private String password;
    private String passwordHint;
    private boolean checkBox1;
    private boolean checkBox2;

    public User(String email, String password, String passwordHint, boolean checkBox1, boolean checkBox2) {
        this.email = email;
        this.password = password;
        this.passwordHint = passwordHint;
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHint() {
        return this.passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public boolean isCheckBox1() {
        return this.checkBox1;
    }

    public void setCheckBox1(boolean checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public boolean isCheckBox2() {
        return this.checkBox2;
    }

    public void setCheckBox2(boolean checkBox2) {
        this.checkBox2 = checkBox2;
    }
}
