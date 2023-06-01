package AimsProject.Src.Media;

public class Disc extends Media{
    private int length;
	private String director;

	
	public Disc(int id, String title) {
		super(id, title);
	}
	
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Disc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
	}

	public Disc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
	public String toString() {
		return "Disc - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $";
	}
}