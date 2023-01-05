package com.mingkyy.MyDiary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private int hit;

    @Enumerated
    private PostType postType;

    @Enumerated
    private Mood mood;

    @ManyToOne
    private Member write;

    @OneToMany(mappedBy = "posComment", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "goodPost", cascade = CascadeType.ALL)
    private List<Good> goods;

    @OneToMany(mappedBy = "reportPost", cascade = CascadeType.ALL)
    private List<Report> reports;

    @Builder
    public Post(String title, String content, int hit, PostType postType, Mood mood, Member write,
                List<Comment> comments, List<Good> goods, List<Report> reports) {
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.postType = postType;
        this.mood = mood;
        this.write = write;
        this.comments = comments;
        this.goods = goods;
        this.reports = reports;
    }
}
