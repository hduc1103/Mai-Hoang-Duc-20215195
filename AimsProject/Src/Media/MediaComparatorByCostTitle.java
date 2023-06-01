package AimsProject.Src.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media t1, Media t2) {
        if(t1.getCost() != t2.getCost()) return (t1.getCost() > t2.getCost())? 1 : -1; 

        int compared = t1.getTitle().compareTo(t2.getTitle());

        return ((compared > 0)? 1 : -1);
    }
}