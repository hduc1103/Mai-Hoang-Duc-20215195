package AimsProject.Src.Cart;

import AimsProject.Disc.DigitalVideoDisc;

public class carts {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		} else {
			System.out.println("The cart is already full");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("DVD 1 has been added.");
	
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvd2;
				qtyOrdered++;
				System.out.println("DVD 2 has been added.");
			} else {
				System.out.println("The cart is already full.");
			}
		} else {
			System.out.println("The cart is already full.");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered + i] = dvdList[i];
			}
			qtyOrdered += dvdList.length;
		} else {
			System.out.println("The cart is already full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				itemsOrdered[i] = null;
				for (int x = i; i < qtyOrdered; i++) {
					itemsOrdered[x] = itemsOrdered[x + 1];
				}
				qtyOrdered--;
				itemsOrdered[qtyOrdered] = null;
				System.out.println("The disc has been removed");
			}
		}
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void print(){
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i=0; i<qtyOrdered;i++){
			System.out.println((i+1)+"."+"DVD" + "-" + itemsOrdered[i].getTitle() + "- " + itemsOrdered[i].getCategory() + "- " + itemsOrdered[i].getDirector() + "- " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost()+"$");
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***********************CART***********************");
	}

    public DigitalVideoDisc[] getDigitalVideoDiscs() {
        return null;
    }
	public void search_id(int id) {
        boolean isMatch = false;
        for(int i = 0; i < qtyOrdered; i++) {
            if(id == itemsOrdered[i].id) {
                System.out.println(itemsOrdered[i].toString());
                isMatch = true;
            }
        }

        if(!isMatch) System.out.println("No match is found");
    }
	public void search_title(String title) {
        boolean isMatch = false;
        for(int i = 0; i < qtyOrdered; i++) {
            if(title == itemsOrdered[i].getTitle()) {
                System.out.println(itemsOrdered[i].toString());
                isMatch = true;
            }
        }

        if(!isMatch) System.out.println("No match is found");
    }
}
