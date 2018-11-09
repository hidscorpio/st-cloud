package com.st.cloud.usercenter.controller;

import com.st.cloud.usercenter.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 枫竹
 * @version V1.0.0
 * @Title: UserController
 * @Package com.st.cloud.usercenter.controller
 * @date 2018/11/9 11:31
 */
@RequestMapping("/api/user")
@RestController
public class UserController {

    @ApiOperation(value = "资源中心-查询试题", nickname = "UserController-save", response = User.class)
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<?> save(@RequestBody User user) {
        
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
