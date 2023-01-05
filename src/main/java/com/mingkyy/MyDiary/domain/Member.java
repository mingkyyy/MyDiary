package com.mingkyy.MyDiary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    MemberType memberType;

    @Enumerated(EnumType.STRING)
    OAuthType oAuthType;

    @OneToMany(mappedBy = "write", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "reportMember", cascade = CascadeType.ALL)
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "goodMember", cascade = CascadeType.ALL)
    private List<Good> goods = new ArrayList<>();

    @OneToMany(mappedBy = "commentWriter", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Member(String name, String nickname, String email, MemberType memberType,
                  OAuthType oAuthType, List<Post> posts, List<Report> reports, List<Good> goods, List<Comment> comments) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.memberType = memberType;
        this.oAuthType = oAuthType;
        this.posts = posts;
        this.reports = reports;
        this.goods = goods;
        this.comments = comments;
    }
}
