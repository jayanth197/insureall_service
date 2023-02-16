package com.insureall.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.insureall.entity.UserEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.User;
import com.insureall.repository.UserRepository;
import com.insureall.service.UserService;
import com.insureall.util.InsureAllUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepository userRepository;


	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse saveUser(User user) {
		ApiResponse response = new ApiResponse();

		try {
			Optional<UserEntity> optUser = userRepository.findByEmail(user.getEmail());
			if (optUser.isPresent()) {
				response.setStatusCode("999");
				response.setStatusMessage(" Email Id already existed");
			}
			else {

				user.setOtp(InsureAllUtil.generateRandomDigits(6));
				user.setCreatedBy(user.getCreatedBy());
				user.setCreatedDate(InsureAllUtil.getCurrentDateTime());
				user.setStatus(1);
				
			 	UserEntity userEntity = modelMapper.map(user, UserEntity.class);
				
			 	userEntity = userRepository.save(userEntity);		
			 	userEntity.setUpdatedBy(user.getUpdatedBy());
			 	userEntity.setUpdatedDate(user.getUpdatedDate());             
				response.setStatusCode("200");
				response.setStatusMessage("Registration success");

				//sendVerificationEmail(user);
			}

		} catch (DataIntegrityViolationException exception) {

			response.setStatusCode("999");
			response.setStatusMessage("Email Id already existed");
		}
		catch (Exception e) {
			response.setStatusCode("999");
			response.setStatusMessage("Service Failed");
		} 
		finally {
			return response;
		}

	}


	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public ApiResponse login(User user) {
		ApiResponse response = new ApiResponse();
		Optional<UserEntity> optUser = userRepository.findByEmail(user.getEmail()); 
		if (optUser.isPresent()) {
			response.setStatusCode("200");
			response.setStatusMessage("Succesfull");
			UserEntity u = optUser.get();
			String dbPassword = u.getPassword() == null ? "" : u.getPassword();
			if (!user.getPassword().equals(dbPassword)) {
				optUser = null;
				response.setStatusCode("400");
				response.setStatusMessage("Invalid Password or Username");
				response.setResult(optUser);
			}
		}
		else {
			response.setStatusCode("400");
			response.setStatusMessage("Invalid Password or Username");
		}
		response.setResult(optUser);
		return response;

	}





	@Override
	public ApiResponse validateUser(String email) throws UnsupportedEncodingException {
		ApiResponse response = new ApiResponse();
		response.setStatusCode("200");
		response.setStatusMessage("Succesfull");
		Optional<UserEntity> optUser = userRepository.findByEmail(email);

		if (optUser.isPresent()) {
			UserEntity u = optUser.get();
			u.setOtp(InsureAllUtil.generateRandomDigits(6));
			userRepository.save(u);

			sendVerificationEmail(u);

			response.setStatusCode("200");
			response.setStatusMessage("Succesfull");
		} else {
			response.setStatusCode("200");
			response.setStatusMessage("Email Not found");
		}
		return response; 
	}

	private void sendVerificationEmail(UserEntity u) {

	}

	//	
	@Override
	public ApiResponse verifyOtp(User user) {
		ApiResponse response = new ApiResponse();
		Optional<UserEntity> optUser = userRepository.findByEmail(user.getEmail());
		if(optUser.isPresent())
		{
			UserEntity u = optUser.get();

			if(u.getOtp() == user.getOtp())
			{       
				u.setStatus(1);
				userRepository.save(u);
				response.setStatusCode("000");
				response.setStatusMessage("Succesfull");
			}
			else{
				response.setStatusMessage("Invalid OTP");
			}

		}    else {
			response.setStatusMessage("User is not Present");
		}
		return response;
	}



	public void sendVerificationEmail(User user,String siteURL) throws MessagingException, UnsupportedEncodingException{
		String subject="please verify your register email id";
		String senderName="Sofia";
		user.setOtp(InsureAllUtil.generateRandomDigits(6));
		
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		
		userRepository.save(userEntity);
		//		String mailContent="<p>Dear" + user.getFirstName() + ",</p>";
		//		mailContent +="<p> Please click the below link to verify��to your registration:</p>";

		//mailContent += ""+user.getOtp()+"";
		//		mailContent = mailContent.replaceAll("@@Otp",user.getOtp().toString());
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setFrom("akkinepalli.raji1328@gmail.com",senderName);
		helper.setTo(user.getEmail());
		helper.setSubject(subject);
		//		helper.setText(mailContent,true);
		mailSender.send(message);
	} //return response;//����}




	@Override
	public ApiResponse getUserById(int uId) {
		ApiResponse response = new ApiResponse();
		response.setStatusCode("000");
		response.setStatusMessage("Succesfull");
		Optional<UserEntity> optUser = userRepository.findById(uId);

		if (optUser.isPresent()) {
			response.setStatusCode("000");
			response.setStatusMessage(" Successfull ");
			userRepository.findById(uId).get();
		}
		else {
			response.setStatusCode("999");
			response.setStatusMessage(" Invalid User ");
		}
		return response;
	}

	@Override
	public ApiResponse saveOrUpdate(User user) { 

		ApiResponse response = new ApiResponse();
		response.setStatusCode("000");
		response.setStatusMessage("Succesfull");
		
		UserEntity uesrEntity = modelMapper.map(user, UserEntity.class);
		
		userRepository.save(uesrEntity);

		return response;
	}

}




