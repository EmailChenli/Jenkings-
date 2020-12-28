package com.eastcom.sc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.eastcom.gt.data.jpa.service.GenericCurdServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eastcom.gt.common.core.constant.GlobalBusinessCodeEnum;
import com.eastcom.gt.common.core.exception.BusinessException;
import com.eastcom.sc.domain.SampleDO;
import com.eastcom.sc.dto.SampleDTO;
import com.eastcom.sc.repository.SampleRepository;
import com.eastcom.sc.repository.SampleSpecification;
import com.eastcom.sc.service.SampleService;

@Service
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public class SampleServiceImpl extends GenericCurdServiceImpl<SampleRepository, SampleDO,String>
        implements SampleService {

    @Override
    public Page<SampleDTO> page(SampleDTO example, Pageable pageable) {
        Page<SampleDO> doPage = repository.findAll(new SampleSpecification<>(example), pageable);
        List<SampleDO> doList = doPage.toList();

        List<SampleDTO> result = new ArrayList<>();
        doList.forEach(src -> {
            result.add(convertTypeDO(src));
        });

        return new PageImpl<>(result, pageable, doPage.getTotalElements());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    @CachePut(value = "sample", key = "#sampleDO.getId()")
    public SampleDO save(SampleDO sampleDO) {
        // 如果是新增操作，判断Code或者Name是否存在
        if (StringUtils.isEmpty(sampleDO.getId())) {
            SampleDO another = repository.findFirstByCodeOrName(sampleDO.getCode(), sampleDO.getName());
            if (another != null) {
                throw new BusinessException(GlobalBusinessCodeEnum.SUCCESS.code(), "Code或 Name已经存在");
            }
        }

        return repository.save(sampleDO);
    }

    @Override
    @CacheEvict(value = "sample", key = "#id")
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private SampleDTO convertTypeDO(SampleDO sampleDO) {
        SampleDTO sampleDTO = new SampleDTO();
        BeanUtils.copyProperties(sampleDO, sampleDTO);
        return sampleDTO;
    }
}
