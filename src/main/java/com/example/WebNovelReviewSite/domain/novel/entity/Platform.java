package com.example.WebNovelReviewSite.domain.novel.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "platform")
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long platformId;

    @Column(name = "platform_name",length = 20)
    private String platformName;

    @Column(name = "platform_image", length = 255)
    private String platformImage;

    //플랫폼 - 소설
    @ManyToMany
    @JoinTable(name = "novel_platform",
            joinColumns = @JoinColumn(name = "platform_id"),
            inverseJoinColumns = @JoinColumn(name = "novel_id"))
    private List<Novel> novelsInPlatform = new ArrayList<>();

}
