package com.smartcloud.auth.provider.config.auth.token;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 二维码Token
 */
public class QrAuthenticationToken extends MyAuthenticationToken {
    public QrAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public QrAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
