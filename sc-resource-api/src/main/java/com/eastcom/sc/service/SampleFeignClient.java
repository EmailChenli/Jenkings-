package com.eastcom.sc.service;

import com.eastcom.gt.common.core.validation.group.Create;
import com.eastcom.gt.common.core.validation.group.Update;
import com.eastcom.gt.common.core.wrapper.JsonResponse;
import com.eastcom.gt.common.core.wrapper.PageParams;
import com.eastcom.sc.dto.SampleDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "", url = "", path ="", fallback = SampleFeignFallback.class)
public interface SampleFeignClient {

    /**
     * 通过rootId查询级联类型链
     *
     * @param id
     * @return JsonResponse
     */
    @GetMapping(value = "/v1/sample")
    @ApiOperation(httpMethod = "GET", value = "通过id查询对象")
    JsonResponse getById(@ApiParam(name = "id", value = "id") @RequestParam String id);

    /**
     * 分页查询对象
     *
     * @param pageParams
     * @return
     */
    @PostMapping(value = "/v1/sample/page")
    @ApiOperation(httpMethod = "POST", value = "分页查询对象")
    JsonResponse page(@ApiParam(name = "pageParams", value = "pageParams")
                               @RequestBody PageParams<SampleDTO> pageParams);

    /**
     * 新增对象
     *
     * @param sampleDTO
     * @return JsonResponse
     */
    @PostMapping(value = "/v1/sample/create")
    @ApiOperation(httpMethod = "POST", value = "新增对象")
    JsonResponse save(@ApiParam(name = "typeDTO", value = "新增对象")
                      @Validated({Create.class})
                      @RequestBody SampleDTO sampleDTO);

    /**
     * 更新对象
     *
     * @param sampleDTO
     * @return JsonResponse
     */
    @PostMapping(value = "/v1/sample/update")
    @ApiOperation(httpMethod = "POST", value = "更新对象")
    JsonResponse update(@ApiParam(name = "sampleDTO", value = "更新对象")
                        @Validated({Update.class})
                        @RequestBody SampleDTO sampleDTO);

    /**
     * 通过ID删除对象
     *
     * @param id
     * @return JsonResponse
     */
    @PostMapping(value = "/v1/sample")
    @ApiOperation(httpMethod = "POST", value = "通过ID删除对象")
    JsonResponse deleteById(@ApiParam(name = "id", value = "id")
                            @RequestParam String id);
}