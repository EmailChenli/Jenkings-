package com.eastcom.sc.service.fallback;

import com.eastcom.gt.common.core.wrapper.JsonResponse;
import com.eastcom.gt.common.core.wrapper.JsonResponseBuilder;
import com.eastcom.gt.common.core.wrapper.PageParams;
import com.eastcom.sc.dto.SampleDTO;
import com.eastcom.sc.service.SampleFeignClient;

public class SampleFeignFallback implements SampleFeignClient {

    @Override
    public JsonResponse getById(String id) {
        return JsonResponseBuilder.error();
    }

    @Override
    public JsonResponse page(PageParams<SampleDTO> pageParams) {
        return JsonResponseBuilder.error();
    }

    @Override
    public JsonResponse save(SampleDTO sampleDTO) {
        return JsonResponseBuilder.error();
    }

    @Override
    public JsonResponse update(SampleDTO sampleDTO) {
        return JsonResponseBuilder.error();
    }

    @Override
    public JsonResponse deleteById(String id) {
        return JsonResponseBuilder.error();
    }
}
