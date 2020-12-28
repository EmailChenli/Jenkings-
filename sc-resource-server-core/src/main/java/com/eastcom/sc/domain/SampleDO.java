package com.eastcom.sc.domain;

import com.eastcom.gt.data.jpa.domain.AbstractIdentifierDO;
import com.eastcom.sc.dto.SampleDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "SAMPLE_TABLE")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class SampleDO extends AbstractIdentifierDO {

    @Column(nullable = false, updatable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    public SampleDO() {
    }

    public SampleDO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public SampleDO(SampleDTO sampleDTO) {
        BeanUtils.copyProperties(sampleDTO, this);
    }

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SampleDO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
