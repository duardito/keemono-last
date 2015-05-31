package com.keemono.core.mysql.Repository.user;

import com.keemono.core.mysql.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by edu on 31/05/2015.
 */
public interface UserRepository  extends JpaRepository<User, Long> {
}
