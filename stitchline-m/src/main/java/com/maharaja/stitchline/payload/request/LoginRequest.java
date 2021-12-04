package com.maharaja.stitchline.payload.request;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/4/2021
 **/
public class LoginRequest {


    private String username;


    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
