package com.eastcom.sc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

import com.eastcom.sc.dto.SampleDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SampleSpecification<SampleDO> implements Specification<SampleDO> {

    SampleDTO sampleDTO;

    public SampleSpecification(SampleDTO sampleDTO) {
        this.sampleDTO = sampleDTO;
    }

    @Override
    public Predicate toPredicate(Root<SampleDO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        if (sampleDTO != null) {
            if (StringUtils.isNotEmpty(sampleDTO.getCode())) {
				Path<String> code = root.get("code");
				predicates.add(cb.equal(code, sampleDTO.getCode()));
            }
			if (StringUtils.isNotEmpty(sampleDTO.getName())) {
				Path<String> name = root.get("name");
				predicates.add(cb.like(name, StringUtils.wrap(sampleDTO.getCode(), "%")));
			}
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }

}
