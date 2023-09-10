package com.suresh;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.suresh.config.ProjectConfig;
import com.suresh.model.Song;
import com.suresh.services.VehicleServices;

@SpringBootApplication
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
		try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
			var vehicleServices = context.getBean(VehicleServices.class);
			System.out.println(vehicleServices.getClass());
			Song song = new Song();
			song.setTitle("Blank Space");
			song.setSingerName("Taylor Swift");
			boolean vehicleStarted = true;
			String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
			String playMusicStatus = vehicleServices.playMusic(vehicleStarted, song);
			String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
			System.out.println(moveVehicleStatus);
			System.out.println(playMusicStatus);
			System.out.println(applyBrakeStatus);
			context.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
