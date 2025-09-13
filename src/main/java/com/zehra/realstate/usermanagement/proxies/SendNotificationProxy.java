package com.zehra.realstate.usermanagement.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// This is for localhost testing
//@FeignClient(name= "notification-service", url="localhost:8000")
// This is for eureka discovery
//@FeignClient(name= "notification-service")
// This is when using env variable, if env variable is not set, it will use the default value
//@FeignClient(name = "notification-service", url = "${ENV_VARIABLE_HERE:http://localhost}:8000")
@FeignClient(name = "notification-service", url = "${ZEHRARS_NOTIFICATION_SERVICE_HOST:http://localhost}:8098")
public interface SendNotificationProxy {

    @PostMapping("/notification/notification/email")
    public String sendNotification(@RequestBody String emailDetails);
}
