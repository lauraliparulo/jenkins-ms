package de.jenkins.ms.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.offbytwo.jenkins.JenkinsServer;

import de.jenkins.ms.service.JenkinsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "jenkins")
@RequestMapping("/api/v1/jenkins")
public class JenkinsRESTController {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JenkinsRESTController.class);

	@Autowired
	private JenkinsService jenkinsService;

	/**
	 * GET a list of RegistrationInfos by query
	 * 
	 * @param type
	 * @return
	 */
	@ApiOperation(value = "Retrieve the jenkins server connection",
	      nickname = "retrieveJenkinsConnection", notes = "", response = JenkinsResponse.class,
	      responseContainer = "Object")
	  @ApiResponses(value = {
	      @ApiResponse(code = 200, message = "Successfully connected to Jenkins server",
	          response = JenkinsResponse.class, responseContainer = "List"),
	      @ApiResponse(code = 400, message = "Invalid Token"),
	      @ApiResponse(code = 401, message = "Unauthorized"),
	      @ApiResponse(code = 403, message = "Forbidden"),
	      @ApiResponse(code = 405, message = "Method not Allowed"),
	      @ApiResponse(code = 500, message = "Internal Server Error")})
	  @RequestMapping(value = "", produces = {"application/json"},
	      // consumes = {"application/json"},
	      method = RequestMethod.GET)
	  public ResponseEntity<JenkinsResponse> retrieveJenkinsConnection(){
		  
		  try {
			JenkinsServer jenkinsServer = jenkinsService.getJenkinsServerConnection();
			
			JenkinsResponse jenkinsResponse = new JenkinsResponse(
					jenkinsServer.getVersion(), jenkinsServer.getJobs().size());
			
			if(jenkinsServer!=null) {
				return new ResponseEntity<JenkinsResponse>(jenkinsResponse, HttpStatus.OK);
			}
		  }
			 catch (URISyntaxException e) {
			      LOG.error("NOT ACCEPTABLE", e.getLocalizedMessage());
			      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		
			    } catch (Exception e) {
			      LOG.error("INTERNAL SERVER ERROR", e.getLocalizedMessage());
			      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			    } 
			
	
		return null;
		  
	  }
	  

}
