package com.jemgroup.unicab.user;

import com.jemgroup.unicab.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    User findByUserName(String userName);


    User findByEmail(String email);

}
