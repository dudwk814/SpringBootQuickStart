package com.rubypaper.Chapter07.config;

import com.rubypaper.Chapter07.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUser extends User {

    private static final long serialVersionUID = 1L;

    public SecurityUser(Member member) {
        super(member.getId(),  member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}
