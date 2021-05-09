package com.cg.psd.demo1.service;

import java.util.List;
import java.util.Optional;

import com.cg.psd.demo1.model.Profile;

public interface ProfileService {

	public List<Profile> getProfiles(String name);
	public Optional<Profile> getProfile(String id);
	public void saveProfile(Profile profile);
}
