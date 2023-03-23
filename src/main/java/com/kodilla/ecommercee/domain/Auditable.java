package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @CreatedBy()
    @Column(name = "created_by", updatable = false, insertable = false)
    protected String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false, insertable = false)
    @CreatedDate
    protected Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", updatable = false, insertable = false)
    protected String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date", updatable = false, insertable = false)
    @LastModifiedDate
    protected Date lastModifiedDate;
}
