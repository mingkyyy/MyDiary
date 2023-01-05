package com.mingkyy.MyDiary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String reportText;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member reportMember;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post reportPost;

    @Builder
    public Report(String reportText, Member reportMember, Post reportPost) {
        this.reportText = reportText;
        this.reportMember = reportMember;
        this.reportPost = reportPost;
    }
}
