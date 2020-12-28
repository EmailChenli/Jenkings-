package com.eastcom.sc.repository;

import com.eastcom.gt.data.jpa.repository.GenericJpaRepository;
import com.eastcom.sc.domain.SampleDO;
import org.springframework.stereotype.Repository;


@Repository
public interface SampleRepository extends GenericJpaRepository<SampleDO, String> {


    /**
     * 根据Code或Name查询对象
     *
     * @param code
     * @param name
     * @return
     */
    SampleDO findFirstByCodeOrName(String code, String name);
}
