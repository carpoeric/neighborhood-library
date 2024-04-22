package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);
    static final int MAX_BOOKS = 20;
    static int bookCount = 0;
    static final Book[] books = new Book[MAX_BOOKS];


    public static void displayMainMenu()
    {
        String[] menuOptions =
                {
                        "1 - Show Available Books",
                        "2 - Show Checked Out Books",
                        "3 - Exit (Close App)"
                };

        int maxLength = 0;
        for (String option : menuOptions) {
            if (option.length() > maxLength) {
                maxLength = option.length();
            }
        }
        int boxWidth = maxLength + 4;
        String horizontalLine = "+" + "-".repeat(boxWidth) + "+";

        System.out.println(horizontalLine);
        for (String option : menuOptions) {
            String paddedOption = "| " + option + " ".repeat(boxWidth - option.length() - 3) + "  |";
            System.out.println(paddedOption);
        }
        System.out.println(horizontalLine);
    }


    public static void main(String[] args)
    {
        // Array
        preloadBooks();

        int choice = 0;
        while (choice != 3) {
            // Home Screen Welcome
            System.out.println();
            System.out.println("Welcome to your Neighborhood Library!");

            // display the code at the very top regarding choices
            displayMainMenu();
            System.out.println("Please enter the number corresponding to the option here: ");
            choice = Integer.parseInt(userInput.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    showAvailableBooks(books);
                    break;
                case 2:
                    showCheckedOutBooks(books);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }

    public static void preloadBooks()
    {
        books[0] = new Book(1, "6789998212", "The Lightning Thief");
        books[1] = new Book(2, "6789998213", "The Sea Of Monsters");
        books[2] = new Book(3, "6789998214", "The Titan's Curse");
        books[3] = new Book(4, "6789998215", "The Battle of the Labyrinth");
        books[4] = new Book(5, "6789998216", "The Last Olympian");
        books[5] = new Book(6, "6789998217", "The Chalice of the Gods");
        books[6] = new Book(7, "6789998218", "Twilight");
        books[7] = new Book(8, "6789998219", "New Moon");
        books[8] = new Book(9, "6789998220", "Breaking Dawn");
        books[9] = new Book(10, "6789998221", "Eclipse");
        books[10] = new Book(11, "6789998222", "The Sorcerer's Stone");
        books[11] = new Book(12, "6789998223", "The Chamber of Secrets");
        books[12] = new Book(13, "6789998224", "The Prisoner of Azkaban");
        books[13] = new Book(14, "6789998225", "The Goblet of Fire");
        books[14] = new Book(15, "6789998226", "The Order of the Phoenix");
        books[15] = new Book(16, "6789998227", "The Half-Blood Prince");
        books[16] = new Book(17, "6789998228", "The Deathly Hallows");
        books[17] = new Book(18, "6789998229", "The Hunger Games");
        books[18] = new Book(19, "6789998230", "Catching Fire");
        books[19] = new Book(20, "6789998231", "Mockingjay");
        bookCount = 20;
    }

    public static void showAvailableBooks(Book[] books)
    {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║             Here's all the available books!          ║");
        System.out.println("╠══════╦═════════════════════════════════╦═════════════╣");
        System.out.println("║  ID  ║              Title              ║    ISBN     ║");
        System.out.println("╠══════╬═════════════════════════════════╬═════════════╣");
        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.printf("║ %-5s║ %-31s ║ %-11s ║\n", (i + 1), books[i].getTitle(), books[i].getIsbn());
            }
        }
        System.out.println("╚══════╩═════════════════════════════════╩═════════════╝");
        System.out.println("---");
        System.out.println("What would you like to do?");
        System.out.println("- If you would like to check out a book, please enter the ID Number of the book below. ");
        System.out.println("- If you would like to go back to the home screen, please enter 0 below.");
        System.out.println("---");
        System.out.println("Please enter the number corresponding to the option here: ");
        int userChoice = Integer.parseInt(userInput.nextLine());
        System.out.println("---");

        if (userChoice == 0) {
            System.out.println("Redirecting you back to the home page now...");
        } else if (userChoice >= 1 && userChoice <= bookCount) {
            System.out.print("Enter your name: ");
            String userName = userInput.nextLine();
            System.out.println("---");

            Book selectedBook = books[userChoice - 1];
            selectedBook.checkOut(userName);
            System.out.println("Thank you for checking out \"" + selectedBook.getTitle() + "\"!");
            System.out.println("Redirecting you back to the home page now...");
        } else {
            System.out.println("Invalid selection. Redirecting you back to the home page now...");
        }
    }

    public static void showCheckedOutBooks(Book[] books)
    {
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                Here's all the books currently checked out:                  ║");
        System.out.println("╠══════╦══════════════════════════════════════╦═════════════╦═════════════════╣");
        System.out.println("║  ID  ║              Title                   ║    ISBN     ║ Checked Out To: ║");
        System.out.println("╠══════╬══════════════════════════════════════╬═════════════╬═════════════════╣");
        boolean hasCheckedOutBooks = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                hasCheckedOutBooks = true;
                System.out.printf("║ %-5s║ %-36s ║ %-11s ║ %-10s ║\n", (i + 1), books[i].getTitle(), books[i].getIsbn(), books[i].getCheckedOutTo());
            }
        }
        if (!hasCheckedOutBooks) {
            System.out.println("║                            No books checked out                             ║");
        }
        System.out.println("╚══════╩══════════════════════════════════════════════════════════════════════╝");


        System.out.println("What would you like to do? ");
        System.out.println("---");
        System.out.println("C - Check in/Return a book.");
        System.out.println("X - Go back to the home screen.");
        System.out.println("---");
        System.out.println("Please enter the Letter corresponding to the option here: ");
        String userChoice = userInput.nextLine();
        System.out.println("---");

        switch (userChoice.toUpperCase()) {
            case "C":
                checkInBook();
                break;
            case "X":
                System.out.println("Redirecting you back to the home page now...");
                return;
            // Go back home
            default:
                System.out.println("Invalid selection. Redirecting you back to the home page now...");
                break;
        }
    }

    public static void checkInBook()
    {
        System.out.print("Please enter the ID of the book you want to check in: ");
        int bookId = Integer.parseInt(userInput.nextLine());
        System.out.println("---");

        if (bookId >= 1 && bookId <= bookCount && books[bookId - 1].isCheckedOut()) {
            books[bookId - 1].checkIn();
            System.out.println("Redirecting you back to the home page now...");
        } else {
            System.out.println("Invalid book ID or the book is not currently checked out.");
            System.out.println("Redirecting you back to the home page now...");
        }
    }
}