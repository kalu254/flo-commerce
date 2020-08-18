package com.kalu.flo.service;

import com.kalu.flo.model.UserEntity;

public interface UserService {
    UserEntity findOrCreateUser(String name,
                                String surname,
                                String email,
                                String phone,
                                String address
    );
}
