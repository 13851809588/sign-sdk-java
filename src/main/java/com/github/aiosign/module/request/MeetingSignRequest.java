package com.github.aiosign.module.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.aiosign.base.AbstractSignRequest;
import com.github.aiosign.base.RequestInfo;
import com.github.aiosign.enums.ContentType;
import com.github.aiosign.enums.HttpMethod;
import com.github.aiosign.module.response.MeetingSignResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 会签传入参数
 *
 * @author modificial
 * @since 2020/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingSignRequest extends AbstractSignRequest<MeetingSignResponse> {

	/**
	 * 合同id
	 */
	private String contractId;

	/**
	 * 签章详细信息
	 */
	private List<SignDetail> signDetails;

	/**
	 * 签章详细参数
	 */
	@Data
	public static class SignDetail implements Serializable {
		/**
		 * 用户id
		 */
		private String userId;

		/**
		 * 印章id
		 */
		private String sealId;

		/**
		 * 页码
		 */
		private Integer pageNum;

		/**
		 * 印章规格
		 */
		private String signSize;

		/**
		 * 签署距离合同上方距离
		 */
		private Integer signTop;

		/**
		 * 签署距离合同左方距离
		 */
		private Integer signLeft;

	}

	@Override
	@JsonIgnore
	public RequestInfo<MeetingSignResponse> getRequestInfo() {
		RequestInfo<MeetingSignResponse> requestInfo = new RequestInfo<>();
		requestInfo.setContentType(ContentType.JSON);
		requestInfo.setApiUri("sign/single");
		requestInfo.setMethod(HttpMethod.POST);
		requestInfo.setNeedToken(true);
		requestInfo.setResponseType(MeetingSignResponse.class);
		requestInfo.setRequestBody(this);
		return requestInfo;
	}
}
