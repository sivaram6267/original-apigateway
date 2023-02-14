package com.example.demo;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidator {

	public static final List<String> openApiEndpoints = List.of("/api/login","/api/admin/getAllProducts",
			 "/api/user/register", "/api/sendOtp", "/auth/register",
			 "/admin/sendOtp", "/api/verify", 
			"/api/admin/getCategories","/api/admin/register");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));

}
