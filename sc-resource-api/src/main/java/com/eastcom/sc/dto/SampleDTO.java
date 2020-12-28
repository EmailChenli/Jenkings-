package com.eastcom.sc.dto;

import com.eastcom.gt.common.core.dto.BaseIdentifierDTO;
import com.eastcom.gt.common.core.validation.group.Create;
import com.eastcom.gt.common.core.validation.group.Update;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;

@ApiModel(value = "样例DTO")
public class SampleDTO extends BaseIdentifierDTO {

    /**
     * 编码
     */
    @NotNull(groups = {Create.class, Update.class}, message = "编码不能为空")
    private String code;

    /**
     * 名称
     */
    @NotNull(groups = {Create.class, Update.class}, message = "名称不能为空")
    private String name;

    /**
     * 描述
     */
    private String description;

    public SampleDTO() {
    }

    public SampleDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SampleDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
