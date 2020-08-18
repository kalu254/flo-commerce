package com.kalu.flo.service;

import com.kalu.flo.model.UserEntity;
import com.kalu.flo.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static com.kalu.flo.model.UserRole.CUSTOMER;
import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService{

    private final UserEntityRepository userEntityRepository;

    public UserServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public UserEntity findOrCreateUser(String name, String surname, String email, String phone, String address) {
        UserEntity userEntity = userEntityRepository.findByEmail(email);
        if (nonNull(userEntity)){
            return userEntity;
        }

        userEntity = new UserEntity();
        userEntity.setRole(CUSTOMER.name());
        userEntity.setEmail(email);
        userEntity.setSurname(surname);
        userEntity.setName(name);
        userEntity.setPhone(phone);

        return userEntityRepository.save(userEntity);
    }
}
