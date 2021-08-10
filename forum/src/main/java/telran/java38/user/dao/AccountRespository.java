package telran.java38.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java38.user.model.UserProfile;

public interface AccountRespository extends MongoRepository<UserProfile, String> {

}
