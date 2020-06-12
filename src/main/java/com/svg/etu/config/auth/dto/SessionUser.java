package com.svg.etu.config.auth.dto;

import com.svg.etu.user.UserVO;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String img;

    public SessionUser(UserVO user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.img = user.getImg();
    }

}
