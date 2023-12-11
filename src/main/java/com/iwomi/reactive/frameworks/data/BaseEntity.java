package com.iwomi.reactive.frameworks.data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@ToString
@EqualsAndHashCode
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID uuid;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp CreatedAt;

    @UpdateTimestamp
    private Timestamp UpdatedAt;
}
