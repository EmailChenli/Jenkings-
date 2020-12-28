package com.eastcom.sc.service;

import com.eastcom.gt.data.jpa.service.GenericCurdService;
import com.eastcom.sc.domain.SampleDO;
import com.eastcom.sc.dto.SampleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SampleService extends GenericCurdService<SampleDO,String> {

    /**
     * 分页查询
     *
     * @param example
     * @param pageable
     * @return
     */
    Page<SampleDTO> page(SampleDTO example, Pageable pageable);
}