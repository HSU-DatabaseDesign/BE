package com.example.WebNovelReviewSite.domain.user.entity;

import com.example.WebNovelReviewSite.domain.author.entity.AuthorInfo;
import com.example.WebNovelReviewSite.domain.badge.entity.Badge;
import com.example.WebNovelReviewSite.domain.novel.entity.Collection;
import com.example.WebNovelReviewSite.domain.review.entity.Review;
import com.example.WebNovelReviewSite.domain.user.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "id",length = 20)
    private String id;

    @Column(name = "passwd",length = 20)
    private String passwd;

    @Column(name = "nickname",length = 20)
    private String nickname;

    @Column(name = "email",length = 254)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private Role role;

    //user - user_badge
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserBadge> userBadges = new  ArrayList<>();

    //user - follow
    @OneToMany(mappedBy = "follower")
    private Set<Follow> followings = new HashSet<>();

    @OneToMany(mappedBy = "target")
    private Set<Follow> followers = new HashSet<>();

    //유저 - 작가
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AuthorInfo authorInfo;

    //유저 - 컬렉션
    @OneToMany(mappedBy = "user")
    private List<Collection> collections = new ArrayList<>();

    //유저 리뷰
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    //좋아요
    @ManyToMany(mappedBy = "userList")
    private List<Review> likeList = new ArrayList<>();
}
