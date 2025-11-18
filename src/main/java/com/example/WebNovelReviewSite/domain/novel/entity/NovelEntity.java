package com.example.WebNovelReviewSite.domain.novel.entity;

import com.example.WebNovelReviewSite.domain.hashtag.entity.HashtagEntity;
import com.example.WebNovelReviewSite.domain.novel.enums.Genre;
import com.example.WebNovelReviewSite.domain.novel.enums.NovelStatus;
import com.example.WebNovelReviewSite.domain.novel.enums.RestrictedType;
import com.example.WebNovelReviewSite.domain.review.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "novel")
@Getter
@Setter
public class NovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "novel_id")
    private Long novelId;

    @Column(name = "novel_name",length = 255)
    private String novelName;

    @Column(name ="novel_author",length = 20)
    private String novelAuthor;

    @Column(name = "novel_context")
    private String novelContext;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "restricted")
    @Enumerated(EnumType.STRING)
    private RestrictedType restricted;

    @Column(name = "novel_status")
    @Enumerated(EnumType.STRING)
    private NovelStatus novelStatus;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    //소설 - 컬렉션
    @ManyToMany(mappedBy = "novelInCollection")
    private List<CollectionEntity> inCollections = new ArrayList<>();

    //해시태그 - 소설
    @ManyToMany(mappedBy = "taggedNovels")
    private List<HashtagEntity> hashtags = new ArrayList<>();

    //소설 - 리뷰
    @OneToMany(mappedBy = "novel")
    private List<ReviewEntity> reviews = new ArrayList<>();

    //소설 - 플랫폼
    @ManyToMany(mappedBy = "novelsInPlatform")
    private List<PlatformEntity> platforms = new ArrayList<>();

    //소설 - 소설 이미지
    @OneToMany(mappedBy = "novel")
    private List<NovelImageEntity> images = new ArrayList<>();
}
