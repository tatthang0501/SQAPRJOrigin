package ptit.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginForm implements Serializable{
    private String username;
    private String password;
}
