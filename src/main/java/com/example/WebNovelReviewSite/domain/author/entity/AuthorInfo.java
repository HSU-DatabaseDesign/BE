package com.example.WebNovelReviewSite.domain.author.entity;

import com.example.WebNovelReviewSite.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author_info")
public class AuthorInfo {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // 유저 키가 FK이면서 PK인 경우
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "pen_name", length = 20)
    private String penName;

    @Column(name = "nationality", length = 20)
    private String nationality;

    @Column(name = "debut_year", length = 4)
    private String debutYear;

    @Column(name = "brief", length = 255)
    private String brief;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Column(name = "is_confirmed")
    private Boolean isConfirmed;

}
