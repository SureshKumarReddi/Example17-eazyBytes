package com.suresh.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.suresh.interfaces.Speakers;
import com.suresh.model.Song;

@Component
@Primary
public class SonySpeakers implements Speakers {

	@Override
	public String makeSound(Song song) {
		return "Playing the song " + song.getTitle() + " by " + song.getSingerName() + " with Sony speakers";
	}

}
