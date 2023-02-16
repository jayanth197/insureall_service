package com.insureall.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import com.insureall.entity.UserEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.User;

public interface UserService {

	ApiResponse saveUser(User user);

	ApiResponse login(User user);

	ApiResponse validateUser(String email) throws UnsupportedEncodingException;

	ApiResponse verifyOtp(User user);

	List<UserEntity> findAll();

	ApiResponse getUserById(int uId);

	ApiResponse saveOrUpdate(User user);

	void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

}
