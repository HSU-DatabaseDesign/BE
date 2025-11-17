package com.example.WebNovelReviewSite.domain.novel.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "platform")
public class PlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Long id;

    @Column(name = "platform_name",length = 20)
    private String name;

    @Column(name = "platform_image", length = 255)
    private String image;

    //플랫폼 - 소설
    @ManyToMany
    @JoinTable(name = "novel_platform",
            joinColumns = @JoinColumn(name = "platform_id"),
            inverseJoinColumns = @JoinColumn(name = "novel_id"))
    private List<NovelEntity> novelsInPlatform = new ArrayList<>();

}
