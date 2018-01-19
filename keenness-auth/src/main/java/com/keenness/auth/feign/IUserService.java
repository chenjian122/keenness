package com.keenness.auth.feign;

import com.keenness.common.vo.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cj
 * @create 2018-01-19 15:09
 **/
@FeignClient(value = "keenness-admin")
public interface IUserService {

    @RequestMapping(value = "/user/validate")
    public UserInfo validate(@RequestParam("username") String username, @RequestParam("password") String password);
}
