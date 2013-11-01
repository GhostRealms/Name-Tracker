package com.rmarmorstein;

import java.util.concurrent.atomic.AtomicBoolean;

import mojang.api.profiles.HttpProfileRepository;
import mojang.api.profiles.Profile;
import mojang.api.profiles.ProfileCriteria;

public class Converter implements Runnable {
	
	private static final HttpProfileRepository repo = new HttpProfileRepository();
	private static final String AGENT = "minecraft";
	private final String username;
	private String uuid;
	private final AtomicBoolean completed = new AtomicBoolean(false);
	
	public Converter(String username) {
		this.username = username;
	}
	
	@Override
	public void run() {
		Profile[] profiles = repo.findProfilesByCriteria(new ProfileCriteria[] {new ProfileCriteria(this.username, AGENT)});
		if(profiles.length == 1) {
			this.uuid = profiles[0].getId();
		} else {
			this.uuid = null;
		}
		
		this.completed.set(true);
		profiles = null;
	}
	
	public String getUUID() {
		return uuid;
	}
	
	public String getUsername() {
		return username;
	}
}
