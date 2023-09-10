package com.suresh.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suresh.interfaces.Speakers;
import com.suresh.interfaces.Tyres;
import com.suresh.model.Song;

@Component
public class VehicleServices {

	private Logger logger = Logger.getLogger(VehicleServices.class.getName());

	@Autowired
	private Speakers speakers;
	private Tyres tyres;

	public Speakers getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Speakers speakers) {
		this.speakers = speakers;
	}

	public Tyres getTyres() {
		return tyres;
	}

	@Autowired
	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}

	public String playMusic(boolean vehicleStarted, Song song) {
		String music = null;
		if (vehicleStarted) {
			music = speakers.makeSound(song);
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" + " operation");
		}

		return speakers.makeSound(song);
	}

	public String moveVehicle(boolean vehicleStarted) {
		String status = null;
		if (vehicleStarted) {
			status = tyres.rotate();
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" + " operation");
		}

		return tyres.rotate();
	}

	public String applyBrake(boolean vehicleStarted) {
		String status = null;
		if (vehicleStarted) {
			status = tyres.stop();
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" + " operation");
		}

		return tyres.stop();
	}

}
