package com.suresh.implementation;

import org.springframework.stereotype.Component;

import com.suresh.interfaces.Speakers;
import com.suresh.model.Song;

@Component
public class BoseSpeakers implements Speakers {

	public String makeSound(Song song) {
		return "Playing the song " + song.getTitle() + " by " + song.getSingerName() + " with Bose speakers";
	}

}