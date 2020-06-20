package com.github.aiosign.module.response;

import com.github.aiosign.base.AbstractSignResponse;
import com.github.aiosign.base.BaseSignObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业用户注册，解锁，注销返回数据
 *
 * @author modificial
 * @since 2020/4/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCompanyResponse  extends AbstractSignResponse {

	private UserCompanyModule data;

	@EqualsAndHashCode(callSuper = true)
	@Data
	public static class UserCompanyModule extends BaseSignObject {
		/**
		 * 企业用户id
		 */
		private String userId;
	}
}
