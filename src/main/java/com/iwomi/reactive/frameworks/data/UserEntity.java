package com.iwomi.reactive.frameworks.data;

import com.iwomi.reactive.frameworks.data.listeners.PersistEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@EntityListeners(PersistEntityListener.class)
public class UserEntity extends BaseEntity{
    private String name;
    private String email;
}
