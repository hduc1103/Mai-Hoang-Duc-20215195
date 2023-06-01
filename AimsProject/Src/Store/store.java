package AimsProject.Src.Store;

import AimsProject.Src.Media.DigitalVideoDisc;
import AimsProject.Src.Media.Media;
import java.util.ArrayList;

public class store {

    private int MAX = 1000;
    private ArrayList<Media> cur_items = new ArrayList<>();
    private ArrayList<Media> itemInStore = new ArrayList<Media>();

    public void addMedia(Media disc){
        if(cur_items.size()<MAX){
            cur_items.add(disc);
        }
        else {
            System.out.println("Exceed max capacity\n");

        }
    }

    public void removeMedia(Media disc){
		if(cur_items.isEmpty()) {
			System.out.println("The store is empty.");
		}
		else if (!cur_items.contains(disc)) {
			System.out.println("The media you want to remove is not in the store.");
		}
		else {
			cur_items.remove(disc);
			System.out.println("Removed");
		}
	}

    public Media search(String title) {
        for (Media media : itemInStore) {
            if(media.getTitle() == title) {
                media.toString();
                return media;
            }
        }
        return null;
    }
    public void print_store() {
        if (itemInStore.size() > 0) {
            System.out.println("STORE\n----------------------------------------------------------------------------------------------");
            for (Media m : itemInStore) {
                System.out.println(m.toString());
            }
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Total number of items in store: " + itemInStore.size());
        } else System.out.println("No item in store");
    }

    public void addMedia(DigitalVideoDisc dvd) {
    }
}