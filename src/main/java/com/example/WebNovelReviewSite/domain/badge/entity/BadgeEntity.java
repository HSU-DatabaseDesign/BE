package com.example.WebNovelReviewSite.domain.badge.entity;


import com.example.WebNovelReviewSite.domain.badge.enums.BadgeType;
import com.example.WebNovelReviewSite.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "badge")
public class BadgeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "badge_id")
    private Long badgeId;

    @Column(name = "badge_name",length = 20)
    private String badgeName;
    
    @Column(name = "badge_image",length = 255)
    private String badgeImage;

    @Column(name = "badge_type")
    @Enumerated(EnumType.STRING)
    private BadgeType badgeType;

    @Column(name = "badge_mission",length = 30)
    private String badgeMission;

    @Column(name = "condition_value")
    private Integer conditionValue;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    //뱃지 - 유저 관계
    @ManyToMany(mappedBy = "badges")
    private Set<UserEntity> users = new HashSet<>();
}
