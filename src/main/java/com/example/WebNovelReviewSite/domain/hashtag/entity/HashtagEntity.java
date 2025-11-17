package com.example.WebNovelReviewSite.domain.hashtag.entity;

import com.example.WebNovelReviewSite.domain.novel.entity.NovelEntity;
import com.example.WebNovelReviewSite.domain.review.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name ="hashtag")
public class HashtagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long hashtagId;

    @Column(name = "hashtag_name",length = 10)
    private String hashtagName;

    //해시태그 - 리뷰
    @ManyToMany
    @JoinTable(name = "review_hashtag",
            joinColumns = @JoinColumn(name = "hashtag_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<ReviewEntity> taggedReviews = new ArrayList<>();

    //해시태그 - 작가
    @ManyToMany
    @JoinTable(name = "novel_hashtag",
            joinColumns = @JoinColumn(name = "hashtag_id"),
            inverseJoinColumns = @JoinColumn(name = "novel_id")
    )
    private List<NovelEntity> taggedNovels = new ArrayList<>();
}
