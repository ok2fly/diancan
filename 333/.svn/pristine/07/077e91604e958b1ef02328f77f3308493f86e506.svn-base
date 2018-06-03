package com.gcfd.model;

/**
 * API基础表
 * @author WGX
 *
 */
public class Api {
	
	/**
	 * 主键 uuid
	 */
	private Long id;
	/**
	 * api编号
	 */
	private String api_id;
	/**
	 * API名称
	 */
	private String api_name;
	/**
	 * API简述
	 */
	private String api_bref_desc;
	/**
	 * API描述
	 */
	private String api_desc;
	/**
	 * API接口状态（正常，发布，规划，开发中，废弃）
	 * 'normal','release',' planning','development','abandoned'
	 */
	private String status;
	
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 访问令牌
	 */
	private String access_token;
	
	/**
	 * 接口访问方式
	 * 'get','post'
	 */
	private String api_access_type;
	/**
	 * 接口地址
	 */
	private String api_url;
	/**
	 * 请求参数
	 */
	private String api_request_parameters;
	/**
	 * 参数说明
	 */
	private String api_request_parameters_memo;
	/**
	 * api返回结果
	 */
	private String api_reponse_data;
	/**
	 * 返回结果说明
	 */
	private String api_reponse_data_memo;
	
	
	//false表示未选中，true表示选中
		private Boolean LAY_CHECKED = false;

		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApi_id() {
		return api_id;
	}
	public void setApi_id(String api_id) {
		this.api_id = api_id;
	}
	public String getApi_name() {
		return api_name;
	}
	public void setApi_name(String api_name) {
		this.api_name = api_name;
	}
	public String getApi_bref_desc() {
		return api_bref_desc;
	}
	public void setApi_bref_desc(String api_bref_desc) {
		this.api_bref_desc = api_bref_desc;
	}
	public String getApi_desc() {
		return api_desc;
	}
	public void setApi_desc(String api_desc) {
		this.api_desc = api_desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getApi_access_type() {
		return api_access_type;
	}
	public void setApi_access_type(String api_access_type) {
		this.api_access_type = api_access_type;
	}
	public String getApi_url() {
		return api_url;
	}
	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}
	public String getApi_request_parameters() {
		return api_request_parameters;
	}
	public void setApi_request_parameters(String api_request_parameters) {
		this.api_request_parameters = api_request_parameters;
	}
	public String getApi_request_parameters_memo() {
		return api_request_parameters_memo;
	}
	public void setApi_request_parameters_memo(String api_request_parameters_memo) {
		this.api_request_parameters_memo = api_request_parameters_memo;
	}
	public String getApi_reponse_data() {
		return api_reponse_data;
	}
	public void setApi_reponse_data(String api_reponse_data) {
		this.api_reponse_data = api_reponse_data;
	}
	public String getApi_reponse_data_memo() {
		return api_reponse_data_memo;
	}
	public void setApi_reponse_data_memo(String api_reponse_data_memo) {
		this.api_reponse_data_memo = api_reponse_data_memo;
	}
	public Boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}
	public void setLAY_CHECKED(Boolean lAY_CHECKED) {
		LAY_CHECKED = lAY_CHECKED;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LAY_CHECKED == null) ? 0 : LAY_CHECKED.hashCode());
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((api_access_type == null) ? 0 : api_access_type.hashCode());
		result = prime * result + ((api_bref_desc == null) ? 0 : api_bref_desc.hashCode());
		result = prime * result + ((api_desc == null) ? 0 : api_desc.hashCode());
		result = prime * result + ((api_id == null) ? 0 : api_id.hashCode());
		result = prime * result + ((api_name == null) ? 0 : api_name.hashCode());
		result = prime * result + ((api_reponse_data == null) ? 0 : api_reponse_data.hashCode());
		result = prime * result + ((api_reponse_data_memo == null) ? 0 : api_reponse_data_memo.hashCode());
		result = prime * result + ((api_request_parameters == null) ? 0 : api_request_parameters.hashCode());
		result = prime * result + ((api_request_parameters_memo == null) ? 0 : api_request_parameters_memo.hashCode());
		result = prime * result + ((api_url == null) ? 0 : api_url.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Api other = (Api) obj;
		if (LAY_CHECKED == null) {
			if (other.LAY_CHECKED != null)
				return false;
		} else if (!LAY_CHECKED.equals(other.LAY_CHECKED))
			return false;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (api_access_type == null) {
			if (other.api_access_type != null)
				return false;
		} else if (!api_access_type.equals(other.api_access_type))
			return false;
		if (api_bref_desc == null) {
			if (other.api_bref_desc != null)
				return false;
		} else if (!api_bref_desc.equals(other.api_bref_desc))
			return false;
		if (api_desc == null) {
			if (other.api_desc != null)
				return false;
		} else if (!api_desc.equals(other.api_desc))
			return false;
		if (api_id == null) {
			if (other.api_id != null)
				return false;
		} else if (!api_id.equals(other.api_id))
			return false;
		if (api_name == null) {
			if (other.api_name != null)
				return false;
		} else if (!api_name.equals(other.api_name))
			return false;
		if (api_reponse_data == null) {
			if (other.api_reponse_data != null)
				return false;
		} else if (!api_reponse_data.equals(other.api_reponse_data))
			return false;
		if (api_reponse_data_memo == null) {
			if (other.api_reponse_data_memo != null)
				return false;
		} else if (!api_reponse_data_memo.equals(other.api_reponse_data_memo))
			return false;
		if (api_request_parameters == null) {
			if (other.api_request_parameters != null)
				return false;
		} else if (!api_request_parameters.equals(other.api_request_parameters))
			return false;
		if (api_request_parameters_memo == null) {
			if (other.api_request_parameters_memo != null)
				return false;
		} else if (!api_request_parameters_memo.equals(other.api_request_parameters_memo))
			return false;
		if (api_url == null) {
			if (other.api_url != null)
				return false;
		} else if (!api_url.equals(other.api_url))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
