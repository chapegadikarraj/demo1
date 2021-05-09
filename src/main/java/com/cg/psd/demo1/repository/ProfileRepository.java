package com.cg.psd.demo1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.psd.demo1.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String>{

	public List<Profile> findByName(String name);
	public Optional<Profile> findById(String id);
}
