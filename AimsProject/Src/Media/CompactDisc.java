package AimsProject.Src.Media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director);
		this.artist = artist;
	}
    
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("The track doesn't exist!");
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("The track doesn't exist!");

        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        System.out.println("Playing Compact Disc:");
        System.out.println("Title: " + getTitle());
        System.out.println("Director: " + getDirector());
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " minutes");
        System.out.println("Tracks:");
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            System.out.println((i + 1) + ". " + track.getTitle() + " - " + track.getLength() + " minutes");
        }
    }
    
}
