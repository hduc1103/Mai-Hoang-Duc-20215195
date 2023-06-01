package AimsProject.Src.Media;

public class Track implements Playable {
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public void play(){
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
    public boolean equals(Object c) {
        if(c == this) return true;
        if(!(c instanceof Track track)) return false;
        return track.getTitle() == this.getTitle() && track.getLength() == this.getLength();
    }
}
