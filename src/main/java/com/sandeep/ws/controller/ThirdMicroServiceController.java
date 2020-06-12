package com.sandeep.ws.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.ws.model.ThirdMicroServiceResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/m3")
@Api(value = "Third Micro Service", description = "You get concated result of sent payload")
public class ThirdMicroServiceController {

	@PostMapping(path = "/get")
	@ApiOperation(value = "This method concat the the request parameters", response = ResponseEntity.class)
	public ResponseEntity<String> getFullName(@Valid @RequestBody ThirdMicroServiceResponseModel requestModel) {

		String firstName = requestModel.getFirstName();

		String lastName = requestModel.getLastName();
		
		String fullName = firstName+lastName;
		return new ResponseEntity<String>(fullName, HttpStatus.OK);
	}

}
