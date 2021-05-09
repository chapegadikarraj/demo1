package com.cg.psd.demo1.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.psd.demo1.model.Profile;
import com.cg.psd.demo1.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository repository;

	@Override
	public List<Profile> getProfiles(String name) {
		return repository.findByName(name);
	}

	@Override
	public Optional<Profile> getProfile(String id) {
		return repository.findById(id);
	}

	@Override
	public void saveProfile(Profile profile) {
		profile.setId(UUID.randomUUID().toString());
		repository.save(profile);
	}
	

	
}
