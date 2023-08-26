package com.antony.ni.TutorialReview.domain.user.models;

import com.antony.ni.TutorialReview.domain.common.BaseEntity;
import com.antony.ni.TutorialReview.domain.post.models.Post;
import com.antony.ni.TutorialReview.domain.review.models.Review;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Slf4j
@Table(name="Users")
public class User extends BaseEntity {

    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Post> posts;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Review> reviews;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;







}
