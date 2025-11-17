package com.example.WebNovelReviewSite.domain.review.entity;


import com.example.WebNovelReviewSite.domain.hashtag.entity.HashtagEntity;
import com.example.WebNovelReviewSite.domain.novel.entity.NovelEntity;
import com.example.WebNovelReviewSite.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "review")
public class ReviewEntity {

    // 리뷰키
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    //유저 FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;

    //소설 FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id",nullable = false)
    private NovelEntity novel;

    //리뷰 내용
    @Column(name="content", length = 255,nullable = false)
    private String content;

    //별점
    @Column(name="star", precision = 2, scale = 1,nullable = false)
    private BigDecimal star;

    //조회수
    @Column(name = "views",nullable = false)
    private Long views;

    //리뷰 - 해시태그
    @ManyToMany(mappedBy = "taggedReviews")
    private List<HashtagEntity> hashtags = new ArrayList<>();

}
