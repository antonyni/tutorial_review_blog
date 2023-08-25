package com.antony.ni.TutorialReview.domain.user.models;

import com.antony.ni.TutorialReview.domain.common.BaseEntity;
import com.antony.ni.TutorialReview.domain.review.models.Review;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class User extends BaseEntity {

    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Review> Reviews;




}
