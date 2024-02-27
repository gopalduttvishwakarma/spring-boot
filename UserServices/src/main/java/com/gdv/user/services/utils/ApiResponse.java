package com.gdv.user.services.utils;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
	private String message;
	private List<?> data;
}
