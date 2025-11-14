package com.trenchesdeveloper.shielddoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trenchesdeveloper.shielddoc.exception.ApiException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = "createdAt, updatedAt", allowGetters = true)
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_sed", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_sed")
    @Column(name = "id", updatable = false)
    private Long id;

    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();

    @NotNull
    private Long createdBy;

    @NotNull
    private Long updatedBy;

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;



    @PrePersist
    public void prePersist() {
        var userId = 1L; //TODO: get user id from security context
        if (userId == null) {
            throw new ApiException("Cannot persist entity without a valid user ID in request context");
        }
        setCreatedBy(userId);
        setCreatedAt(LocalDateTime.now());
        setUpdatedBy(userId);
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        var userId = 1L; //TODO: get user id from security context
        if (userId == null) {
            throw new ApiException("Cannot update entity without a valid user ID in request context");
        }
        setUpdatedBy(userId);
        setUpdatedAt(LocalDateTime.now());
    }


}





