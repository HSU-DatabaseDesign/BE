package com.example.WebNovelReviewSite.domain.novel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "novel_image")
public class NovelImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "novel_id")
    private NovelEntity novel;

    @Column(name = "image_url")
    private String imageUrl;
}
