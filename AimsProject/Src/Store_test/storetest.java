package AimsProject.Src.Store_test;
import AimsProject.Disc.DigitalVideoDisc;
import AimsProject.Store.*;
public class storetest {
    public static void main(String[] args) {
        store store_test = new store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store_test.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store_test.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "", 0, 18.99f);
        store_test.addDVD(dvd3);

        store_test.removeDVD(dvd3);
    }

}