package AimsProject.Src.Media;

import java.util.Comparator;


public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }    
    public Media(int i, String title2, String category2, float cost2, String director) {
    }

    public Media(int i, String title2, String category2, float cost2, String director, int length) {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Media media)) return false;
        return media.getTitle() == this.getTitle();
    }
}

