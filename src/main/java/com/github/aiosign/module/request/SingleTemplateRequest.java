package com.github.aiosign.module.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.aiosign.base.AbstractSignRequest;
import com.github.aiosign.base.RequestInfo;
import com.github.aiosign.bean.SignFields;
import com.github.aiosign.enums.ContentType;
import com.github.aiosign.enums.HttpMethod;
import com.github.aiosign.module.response.SignResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * 单次模板签章参数
 *
 * @author modificial
 * @version $Id: $Id
 * @since 2020/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleTemplateRequest extends AbstractSignRequest<SignResponse> {
    /**
     * 模板id
     */
    private String templateId;
	/**
	 * 签章信息
	 */
    private SignFields signField;

    /**
     * {@inheritDoc}
     */
    @Override
    @JsonIgnore
    public RequestInfo<SignResponse> getRequestInfo() {
        RequestInfo<SignResponse> requestInfo = new RequestInfo<>();
        requestInfo.setContentType(ContentType.JSON);
        requestInfo.setApiUri("sign/template/single");
        requestInfo.setMethod(HttpMethod.POST);
        requestInfo.setNeedToken(true);
        requestInfo.setResponseType(SignResponse.class);
        requestInfo.setRequestBody(this);
        return requestInfo;
    }
}