package AimsProject.Src.Store;

import java.util.ArrayList;

import AimsProject.Disc.DigitalVideoDisc;

public class store {
    private ArrayList<DigitalVideoDisc> itemInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc disc) {
        itemInStore.add(disc);
        System.out.println("Added a DVD");
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < itemInStore.size(); i++) {
            if (itemInStore.get(i).equals(disc)) {
                itemInStore.remove(i);
                System.out.println("Removed a DVD");
                return;
            }
        }
        System.out.println("DVD not found");
    }
} 
    
