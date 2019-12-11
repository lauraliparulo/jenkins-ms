package de.jenkins.ms.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.offbytwo.jenkins.helper.JenkinsVersion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("JenkinsResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsResponse {

	  @ApiModelProperty(value = "jenkins version", required = false)
	String version;
	  @ApiModelProperty(value = "number of configured jobs", required = false)
	int amountJobs;

	public JenkinsResponse(JenkinsVersion version, int size) {
		this.version = version.getLiteralVersion();
		this.amountJobs = size;// TODO Auto-generated constructor stub
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getAmountJobs() {
		return amountJobs;
	}

	public void setAmountJobs(int size) {
		this.amountJobs = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountJobs;
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
		JenkinsResponse other = (JenkinsResponse) obj;
		if (amountJobs != other.amountJobs)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JenkinsResponse [version=" + version + ", amountJobs=" + amountJobs + "]";
	}

	
}
