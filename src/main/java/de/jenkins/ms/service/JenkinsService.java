package de.jenkins.ms.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

@Service
public class JenkinsService {
	
	  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JenkinsService.class);

	@Value("${jenkins.username}")
	String username;
	
	@Value("${jenkins.password}")
	String password;
	
	@Value("${jenkins.server-url}")
	String url;
	
	JenkinsServer jenkinsServer;
	
	public JenkinsServer getJenkinsServerConnection() throws URISyntaxException {
		jenkinsServer = new JenkinsServer(new URI(url), username, password);

		LOG.info("Connected to Jenkins version"+jenkinsServer.getVersion());
		return jenkinsServer;
		
	}
	
	public Map<String, Job> getJenkinsJobs() throws IOException{
		Map<String, Job> jobs = jenkinsServer.getJobs();
		return jobs;
	}
	
	public JobWithDetails getJobWithDetails(String jobName, Map<String, Job> jobs) throws IOException {
		JobWithDetails job = jobs.get(jobName).details();
		return job;	
	}
	
	
}
