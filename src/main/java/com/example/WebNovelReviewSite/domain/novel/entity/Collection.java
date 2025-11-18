package com.example.WebNovelReviewSite.domain.novel.entity;

import com.example.WebNovelReviewSite.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private Long collectionId;

    //유저 1 : 컬렉션 M
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "collection_name",length = 20)
    private String collectionName;

    @Column(name = "content",length = 255)
    private String content;

    //컬렉션 - 소설
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collected_novel",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "novel_id")
    )
    private List<Novel> novelInCollection = new ArrayList<>();
}
