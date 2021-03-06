package telran.java38.user.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java38.user.dao.AccountRespository;
import telran.java38.user.dto.UserProfileDto;
import telran.java38.user.dto.UserRegDto;
import telran.java38.user.dto.UserUpdateDto;
import telran.java38.user.dto.exceptions.UserConflictException;
import telran.java38.user.dto.exceptions.UserNotFoundException;
import telran.java38.user.model.UserProfile;

@Service
public class AccountServiceImp implements AccountService {

	AccountRespository accountRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public AccountServiceImp(AccountRespository accountRepository, ModelMapper modelMapper) {
		this.accountRepository = accountRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserProfileDto addUser(UserRegDto userRegDto) {
		if(accountRepository.existsById(userRegDto.getLogin())) {
			throw new UserConflictException(userRegDto.getLogin());
		}
		UserProfile userProfile = new UserProfile(userRegDto.getLogin(), userRegDto.getPassword(), userRegDto.getFirstName(), userRegDto.getLastName());
				accountRepository.save(userProfile);
		return modelMapper.map(userProfile, UserProfileDto.class);
	}

	@Override
	public UserProfileDto findUserById(String login) {
		UserProfile userProfile = accountRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		
//		String hashPassword = BCrupt.hashpw(userRegDto.getPassword(), BCrypt.gensalt(), has)
		return modelMapper.map(userProfile, UserProfileDto.class);
	}

	@Override
	public UserProfileDto updateUser(String login, UserUpdateDto userUpdateDto) {
		UserProfile userProfile = accountRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		if(userUpdateDto.getFirstName() != null) {
			userProfile.setFirstName(userUpdateDto.getFirstName());
		}
		if(userUpdateDto.getLastName() != null) {
			userProfile.setLastName(userUpdateDto.getLastName());
		}
		accountRepository.save(userProfile);
		return modelMapper.map(userProfile, UserProfileDto.class);
	}

	@Override
	public UserProfileDto removeUser(String login) {
		UserProfile userProfile = accountRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		accountRepository.delete(userProfile);
		return modelMapper.map(userProfile, UserProfileDto.class);
	}

	@Override
	public void changePassword(String login, String password) {
		UserProfile userProfile = accountRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		if(password != null) {
			userProfile.setPassword(password);
			accountRepository.save(userProfile);
		}

	}

	@Override
	public Set<String> updateRolesList(String login, String role, boolean isSet) {
		UserProfile userProfile = accountRepository.findById(login).orElseThrow(() -> new UserNotFoundException(login));
		if(isSet) {
			userProfile.addRole(role);
		} else {
			userProfile.removeRole(role);
		}
		accountRepository.save(userProfile);
		return userProfile.getRoles();
	}

}
