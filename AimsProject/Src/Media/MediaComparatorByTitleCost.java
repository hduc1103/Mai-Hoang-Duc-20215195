package AimsProject.Src.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media t1, Media t2) {
        int compared = t1.getTitle().compareTo(t2.getTitle());

        if(compared != 0) return ((compared > 0)? 1 : -1);

        return (t1.getCost() > t2.getCost())? 1 : -1; 
    }
}