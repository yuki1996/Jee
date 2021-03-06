package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.UserInfo;

public interface UserDAO {

	public User findEmail(String email);
	
    public PaginationResult<UserInfo> queryUsers(int page,
            int maxResult, int maxNavigationPage);

    public PaginationResult<UserInfo> queryUsers(int page, int maxResult,
            int maxNavigationPage, String likeName);

	public UserInfo findUserInfo(String id);

	public void delete(UserInfo userInfo);

	public void save(UserInfo userInfo);

	public User findUserById(String id);
	   
}
