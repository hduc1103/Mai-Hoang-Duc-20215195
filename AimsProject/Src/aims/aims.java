package AimsProject.Src.aims;

import java.util.Scanner;

import AimsProject.Src.Media.*;
import AimsProject.Src.Store.*;
import AimsProject.Src.Cart.*;
import AimsProject.Src.Media.DigitalVideoDisc;

public class aims {
	// Menu Design
	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("----------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("choices:");
		System.out.println("----------------------");
		System.out.println("1. See a media's detail");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void cartMenu() {
		System.out.println("choices:");
		System.out.println("----------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void mediaDetailsMenu() {
		System.out.println("choices: ");
		System.out.println("----------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("----------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	// Main
	public static void main(String args[]) {
		store store = new store();
		carts cart = new carts();

		Scanner scanner = new Scanner(System.in);
		int re = 1;
		int choice;
		int ID = 1;
		int amount = 0;

		do {
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				int choice1;
				do {
					store.print_store();
					storeMenu();
					choice1 = scanner.nextInt();
					scanner.nextLine();
					if (choice1 == 1) {

						System.out.println("Enter media title: ");
						String title = scanner.nextLine();
						mediaDetailsMenu();
						Media media = store.search(title);

						if (media == null) {
							System.out.println("The media does not exist in the store\n");
							choice = 0;

						} else {
							System.out.println(media.toString());
							mediaDetailsMenu();
							int choice11 = scanner.nextInt();
							scanner.nextLine();
							do {
								if (choice11 == 1) {
									System.out.println("Enter the title of the media you want to add: ");
									String add = scanner.nextLine();
									Media a = store.search(add);
									if (a == null) {
										System.out.println("The title is incorrect\n");
									} else {
										cart.addMedia(a);
										System.out.println("The media has been added to the cart\n");
										amount++;
										System.out.println("Numbers of items in cart: " + amount);
									}
									choice11 = 0;

								} else if (choice11 == 2) {
									if (media instanceof Book) {
										System.out.println("You cannot play a book.");
									} else if (media instanceof CompactDisc) {
										((CompactDisc) media).play();
									} else {
										((DigitalVideoDisc) media).play();
									}
									break;
								} else {
									System.out.println("Invalid choice. Re-enter the choice: ");

								}

							} while (choice11 != 0);
						}
					} else if (choice1 == 2) {
						System.out.println("Enter the title of the media you want to add: ");
						String add = scanner.nextLine();
						Media a = store.search(add);
						if (a == null) {
							System.out.println("The title is incorrect\n");
						} else {
							cart.addMedia(a);
							System.out.println("The media has been added to the cart\n");
							amount++;
							System.out.println("Numbers of items in cart: " + amount);
						}
					} else if (choice1 == 3) {
						System.out.println("Enter the title of the media you want to play: ");
						String play = scanner.nextLine();

						Media media = store.search(play);
						if (media == null) {
							System.out.println("The input title is not available in the store!\n");
						} else {
							if (media instanceof Book) {
								System.out.println("You cannot play a book.");
							} else if (media instanceof CompactDisc) {
								((CompactDisc) media).play();
							} else {
								((DigitalVideoDisc) media).play();
							}
						}
					} else if (choice1 == 4) {
						cart.print();
					}

				} while (choice1 != 0);

			} else if (choice == 2) {
				int choice2;
				do {
					System.out.println("Do you want to ...\n");
					System.out.println("1. Add media\n");
					System.out.println("2. Remove media\n");
					System.out.println("0. Back\n");
					System.out.println("Enter choice: ");
					choice2 = scanner.nextInt();
					scanner.nextLine();
					if (choice2 == 1) {
						System.out.println("Enter the type of media: ");

						String type = scanner.nextLine();
						System.out.println("Enter title: ");
						String title = scanner.nextLine();
						System.out.println("Enter category: ");
						String category = scanner.nextLine();
						System.out.println("Enter price: ");
						float cost = scanner.nextFloat();
						scanner.nextLine();
						if (type.equals("book")) {
							Book book = new Book(ID, title, category, cost);
							System.out.println("Enter number of authors: ");
							int nbAuthors = scanner.nextInt();
							scanner.nextLine();
							for (int i = 1; i <= nbAuthors; i++) {
								System.out.println("Enter author's name: ");
								String author = scanner.nextLine();
								book.add_authors(author);
							}
							store.addMedia(book);
							ID++;

						} else if (type.equals("cd")) {
							System.out.println("Enter director: ");
							String director = scanner.nextLine();
							System.out.println("Enter aritist: ");
							String artist = scanner.nextLine();
							System.out.println("Enter number of tracks: ");
							int nbTracks = scanner.nextInt();
							scanner.nextLine();

							CompactDisc cd = new CompactDisc(ID, title, category, cost, director, artist);

							for (int i = 1; i <= nbTracks; i++) {
								System.out.println("Enter track # " + i + "title: ");
								String ttitle = scanner.nextLine();
								System.out.println("Enter track # " + i + "length: ");
								int tlength = scanner.nextInt();
								scanner.nextLine();
								cd.addTrack(new Track(ttitle, tlength));
							}
							store.addMedia(cd);
							ID++;
						}

						else {
							System.out.println("Enter director: ");
							String director = scanner.nextLine();
							System.out.println("Enter length: ");
							int length = scanner.nextInt();
							scanner.nextLine();
							DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
							store.addMedia(dvd);
							ID++;

						}
					} else if (choice2 == 2) {
						System.out.println("Enter the title of the media you want to remove: ");
						String title = scanner.nextLine();
						Media found = store.search(title);
						if (found == null) {
							System.out.println("Cannot find the media with that title to remove\n");
						} else {
							store.removeMedia(found);
							System.out.println("Removed\n");
						}
					}
				} while (choice2 != 0);

			}

			else if (choice == 3) {

				do {
					cartMenu();
					choice = scanner.nextInt();
					scanner.nextLine();
					if (choice == 1) {
						System.out.println("Enter title: ");
						String title = scanner.nextLine();
						cart.search_title(title);
					} else if (choice == 2) {
						System.out.println("Enter id: ");
						int id = scanner.nextInt();
						scanner.nextLine();
						cart.search_id(id);
					} else if (choice == 3) {
						System.out.println("Enter title: ");
						String title = scanner.nextLine();
						Media found = cart.search_media(title);
						if (found == null) {
							System.out.println("The media is not in the cart ");

						} else {
							cart.removeMedia(found);
							System.out.println("Removed ");

						}
					} else if (choice == 4) {
						System.out.println("Enter title: ");
						String title = scanner.nextLine();
						Media found = cart.search_media(title);
						if (found == null) {
							System.out.println("The media is not in the cart ");

						} else {
							if (found instanceof Book)
								System.out.println("Cannot play a book ");
							else if (found instanceof DigitalVideoDisc)
								((DigitalVideoDisc) found).play();
							else
								((CompactDisc) found).play();
						}
					} else if (choice == 5) {
						System.out.println("An order is created\n");
						cart.empty_cart();
					} else {
						System.out.println("Invalid choice ");
					}
				} while (choice != 0);
			}

			else if (choice == 0) {
				re = 0;
			}

			else {
				System.out.println("Invalid choice. Re-enter the choice: ");
			}
		} while (re != 0);
		scanner.close();
	}
}