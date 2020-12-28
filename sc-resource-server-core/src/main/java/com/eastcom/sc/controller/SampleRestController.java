package com.eastcom.sc.controller;

import com.eastcom.gt.common.core.wrapper.JsonResponse;
import com.eastcom.gt.common.core.wrapper.JsonResponseBuilder;
import com.eastcom.gt.common.core.wrapper.PageParams;
import com.eastcom.gt.common.web.controller.BaseRestController;
import com.eastcom.gt.data.jpa.util.PageUtils;
import com.eastcom.sc.domain.SampleDO;
import com.eastcom.sc.dto.SampleDTO;
import com.eastcom.sc.service.SampleFeignClient;
import com.eastcom.sc.service.SampleService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Api(value = "SampleRestController", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleRestController extends BaseRestController implements SampleFeignClient {

    @Autowired
    private SampleService sampleService;

    @Override
    public JsonResponse getById(String id) {
        SampleDO sampleDO = sampleService.getOne(id).orElse(null);
        return JsonResponseBuilder.ok(sampleDO);
    }

    @Override
    public JsonResponse page(PageParams<SampleDTO> pageParams) {
        SampleDTO sampleDTO = Objects.nonNull(pageParams.getParam()) ? pageParams.getParam() : new SampleDTO();

        Page<SampleDTO> page = sampleService.page(sampleDTO, PageUtils.getPageRequest(pageParams));
        return JsonResponseBuilder.ok(page);
    }

    @Override
    public JsonResponse save(SampleDTO sampleDTO) {
        return JsonResponseBuilder.ok(saveOrUpdate(sampleDTO));
    }

    @Override
    public JsonResponse update(SampleDTO sampleDTO) {
        return JsonResponseBuilder.ok(saveOrUpdate(sampleDTO));
    }

    private SampleDO saveOrUpdate(SampleDTO sampleDTO) {
        SampleDO sampleDO = new SampleDO(sampleDTO);
        return sampleService.save(sampleDO);
    }

    @Override
    public JsonResponse deleteById(String id) {
        sampleService.deleteById(id);
        return JsonResponseBuilder.ok();
    }
}
