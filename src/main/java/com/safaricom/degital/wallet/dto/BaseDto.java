package com.safaricom.degital.wallet.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseDto {
private Long id;
    private LocalDateTime createdAt;
    private String createdBy;

    private LocalDateTime updatedAt;

    private String modifiedBy;
}
