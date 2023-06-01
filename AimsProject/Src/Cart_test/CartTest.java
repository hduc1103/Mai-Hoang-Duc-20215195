package AimsProject.Src.Cart_test;

import AimsProject.Src.Cart.carts;
import AimsProject.Src.Media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args){
        //Create a new cart
        carts cart = new carts();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", null, 0, 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();
        //To-do: Test the search methods here
        cart.search_id(3);
        cart.search_title("Aladin");

}
}
