package com.mingkyy.MyDiary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member goodMember;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post goodPost;

    @Builder
    public Good(Member goodMember, Post goodPost) {
        this.goodMember = goodMember;
        this.goodPost = goodPost;
    }
}
