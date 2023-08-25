package com.antony.ni.TutorialReview.domain.review.models;

import com.antony.ni.TutorialReview.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Slf4j
public class Review extends BaseEntity {
    @NonNull
    @Column(name="user_id")
    private UUID userUUID;
}
