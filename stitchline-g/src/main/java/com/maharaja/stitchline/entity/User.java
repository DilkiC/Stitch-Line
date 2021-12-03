package com.maharaja.stitchline.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

/**
 * @author Dilki Cooray <dilkicooray97@gmal.com>
 * @since 12/2/2021
 **/
@Document(collection = "user")
public class User {

    @Id
    private String id;
    //@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String username;
    private String password;
    private String name;
    private String mobile_number;
    private String date_of_birth;
    private String gender;
    private String language;

    public User() {
    }

    public User(String id, String username, String password, String name, String mobile_number, String date_of_birth, String gender, String language) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobile_number = mobile_number;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
