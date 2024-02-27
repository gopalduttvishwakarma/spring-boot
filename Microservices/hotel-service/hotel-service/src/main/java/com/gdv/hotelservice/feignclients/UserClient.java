package com.gdv.hotelservice.feignclients;

import com.gdv.hotelservice.helper.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @GetMapping("/users/user-by-id/{userId}")
    ApiResponse getUserByUserId(@PathVariable String userId);
}
