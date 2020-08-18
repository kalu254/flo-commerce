package com.kalu.flo.repository;

import com.kalu.flo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository  extends JpaRepository<UserEntity,Integer> {

    UserEntity findByEmail(String email);
}
