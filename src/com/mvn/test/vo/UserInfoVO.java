package com.mvn.test.vo;

import lombok.Data;

@Data //롬복, get,set,toString을 만들어줌
public class UserInfoVO {
	private Integer uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
}
