package com.antony.ni.TutorialReview.domain.post.models;

import com.antony.ni.TutorialReview.domain.common.BaseEntity;
import com.antony.ni.TutorialReview.domain.review.models.Review;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Slf4j
public class Post extends BaseEntity {
    @NonNull
    @Column(name = "user_id")
    private UUID userUUID;

    @NonNull
    private String url;

    @NonNull
    private String description;

    @NonNull
    private String title;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Set<Review> reviews;

    @NonNull
    private Long toots;



}
