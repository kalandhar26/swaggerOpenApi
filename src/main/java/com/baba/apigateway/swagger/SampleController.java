package com.baba.apigateway.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@RestController
@RequestMapping
public class SampleController {

	@GetMapping(value = "/test/swagger")
	@ApiOperation(value = "get endpoint to test", notes = "get endpoints to test", authorizations = {
			@Authorization(value = "Swagger-Application-Security", scopes = {
					@AuthorizationScope(scope = "api:test-swagger", description = "To test swagger") }) })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public String getMyname() {
		return "Baba";
	}

	@PostMapping(value = "/test/{fullname}")
	@ApiOperation(value = "post endpoints to test", notes = "post endpoints to test", authorizations = {
			@Authorization(value = "Swagger-Application-Security", scopes = {
					@AuthorizationScope(scope = "api:test-swagger", description = "To test swagger") }) })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = String.class) })
	public String getMyname(
			@ApiParam(value = "enter your full name", name = "full name enter") @PathVariable(value = "fullname") String fullname) {
		return "Baba" + fullname;
	}

}
