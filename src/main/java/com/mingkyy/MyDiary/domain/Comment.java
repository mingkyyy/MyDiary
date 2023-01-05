package com.mingkyy.MyDiary.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Member commentWriter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post posComment;

    @Enumerated
    private PostType postType;

    @Builder
    public Comment(String comment, Member commentWriter, Post posComment, PostType postType) {
        this.comment = comment;
        this.commentWriter = commentWriter;
        this.posComment = posComment;
        this.postType = postType;
    }
}
