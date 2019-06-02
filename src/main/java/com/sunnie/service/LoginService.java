package com.sunnie.service;


import com.sunnie.pojo.front.Member;

public interface LoginService {

    Member userLogin(String username, String password);

    Member getUserByToken(String token);

    int logout(String token);
}
