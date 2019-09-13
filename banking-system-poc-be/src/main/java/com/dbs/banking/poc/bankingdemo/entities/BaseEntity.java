package com.dbs.banking.poc.bankingdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
@EntityListeners({AuditingEntityListener.class})
@ToString
public class BaseEntity implements Serializable {
    public BaseEntity(Long version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Version
    @Column(name = "version")
    @JsonIgnore
    private Long version;

    @Column(name = "created_at", updatable=false)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
