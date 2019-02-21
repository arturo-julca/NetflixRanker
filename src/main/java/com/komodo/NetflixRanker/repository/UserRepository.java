package com.komodo.NetflixRanker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.komodo.NetflixRanker.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
