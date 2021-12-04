package com.maharaja.stitchline.payload.request;

import javax.validation.constraints.Email;
import java.util.Set;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/4/2021
 **/
public class SignupRequest {
    //@NotBlank
    //@Size(min = 3, max = 20)
    private String username;


    @Email
    private String email;

    private Set<String> roles;


    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }

}
