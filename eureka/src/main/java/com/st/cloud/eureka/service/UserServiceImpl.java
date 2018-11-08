package com.st.cloud.eureka.service;

import com.st.cloud.commom.keygen.KeyGenerator;
import com.st.cloud.eureka.mpdel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 枫竹
 * @version V1.0.0
 * @Title: UserServiceImpl
 * @Package com.st.cloud.eureka.service
 * @date 2018/11/8 18:57
 */
@Service
public class UserServiceImpl {
    private final KeyGenerator keyGenerator;

    @Autowired
    UserServiceImpl(KeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public void saveUser() {
        User user = new User();
        user.setId(keyGenerator.generateKey().toString());
    }
}
