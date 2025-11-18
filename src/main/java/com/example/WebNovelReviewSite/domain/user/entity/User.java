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

    //유저 - 뱃지
    @ManyToMany
    @JoinTable(
            name ="user_badge",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private Set<Badge> badges = new HashSet<>();

    //팔로우 관계
    @ManyToMany
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "target_id")
    )
    private Set<User>  followings = new HashSet<>();

    @ManyToMany(mappedBy = "followings")
    private Set<User> followers = new HashSet<>();

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
