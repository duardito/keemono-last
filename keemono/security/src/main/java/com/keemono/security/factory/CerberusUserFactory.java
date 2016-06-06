package com.keemono.security.factory;

import com.keemono.core.mysql.domain.user.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by edu on 22/05/2016.
 */
public class CerberusUserFactory {

    public static CerberusUser create(User user) {
        return new CerberusUser(
                user.getUuid(),
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getLastPasswordReset(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
        );
    }

}
