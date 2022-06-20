package com.sparta.clonecoding_8be.model;

import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private UserRole userRole;

    @Column
    private String provider;

    @Column
    private String profileImage;

//    @Column
//    private String address;


    public Member(String username, String nickname, String password, UserRole userRole) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.userRole = userRole;
    }

    public Member(String username, String password, String nickname, UserRole userRole, String provider, String profileImage) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userRole = userRole;
        this.provider = provider;
        this.profileImage = profileImage;
    }

    @Builder
    public Member(String username, String password, UserRole userRole, String nickname) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.nickname = nickname;
    }
}

