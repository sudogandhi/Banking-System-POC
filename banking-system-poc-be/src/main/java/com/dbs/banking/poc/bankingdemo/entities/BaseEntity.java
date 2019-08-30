package com.dbs.banking.poc.bankingdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
public class BaseEntity implements Serializable {
    public BaseEntity(Long version, DateTime createdAt, DateTime updatedAt) {
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

    @Column(name = "created_at")
    @JsonIgnore
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @CreatedDate
    private DateTime createdAt;

    @Column(name = "updated_at")
    @JsonIgnore
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @LastModifiedDate
    private DateTime updatedAt;
}
