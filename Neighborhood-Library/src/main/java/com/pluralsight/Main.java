package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);
    static final int MAX_BOOKS = 20;
    static int bookCount = 0;
    static final Book[] books = new Book[MAX_BOOKS];


    public static void displayMainMenu() {
        String[] menuOptions = {
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
        int boxWidth = maxLength +4; // Adding 4 for padding and borders
        String horizontalLine = "+" + "-".repeat(boxWidth) + "+";

        System.out.println(horizontalLine);
        for (String option : menuOptions) {
            String paddedOption = "| " + option + " ".repeat(boxWidth - option.length() - 3) + "|";
            System.out.println(paddedOption);
        }
        System.out.println(horizontalLine);
    }



    public static void main(String[] args)
    {
        // Array
        preloadBooks();

        int choice = 0;
        while (choice != 3)
        {
            // Print home
            System.out.println();
            System.out.println("Welcome to your Neighborhood Library!");;
            displayMainMenu();
            System.out.println("Enter your command command here: ");
            choice = Integer.parseInt(userInput.nextLine());

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
        System.out.println("Here's all the available books!");
        for (int i = 0; i < bookCount; i++)
        {
            if (!books[i].isCheckedOut())
            {
                System.out.println("Book " + (i + 1) + ":");
                System.out.println(books[i]);
                System.out.println();
            }
        }


        System.out.println("Please enter the book number you would like to check out, or enter 0 to go back to the home screen: ");
        int userChoice = Integer.parseInt(userInput.nextLine());

        if (userChoice == 0)
        {
            System.out.println("Redirecting you back to the home page now...");
            return;
        }
        else if (userChoice >= 1 && userChoice <= bookCount)
        {
            System.out.print("Enter your name: ");
            String userName = userInput.nextLine();

            Book selectedBook = books[userChoice - 1];
            selectedBook.checkOut(userName);
            System.out.println();
            System.out.println("Thank you for checking out \"" + selectedBook.getTitle() + "\"!");
            System.out.println("Redirecting you back to the home page now...");
        }
        else
        {
            System.out.println("Invalid selection. Please enter a valid book number.");
        }
    }

    public static void showCheckedOutBooks(Book[] books)
    {
        System.out.println("Here's all the checked out books:");
        boolean hasCheckedOutBooks = false;
        for (int i = 0; i < bookCount; i++)
        {
            if (books[i].isCheckedOut())
            {
                hasCheckedOutBooks = true;
                System.out.println("Book " + (i + 1) + ":");
                System.out.println(books[i]);
                System.out.println();
            }
        }

        if (!hasCheckedOutBooks)
        {
            System.out.println("No books are currently checked out.");
        }


        System.out.println("Enter C to check in a book, or enter X to go back to the home screen: ");
        String userChoice = userInput.nextLine();

        switch (userChoice.toUpperCase())
        {
            case "C":
                checkInBook();
                break;
            case "X":
                System.out.println("Redirecting you back to the home page now...");
                return;
                // Go back home
            default:
                System.out.println("Invalid selection. Please enter C to check in a book, or X to go back to the home screen.");
                break;
        }
    }

    public static void checkInBook()
    {
        System.out.print("Enter the ID of the book you want to check in: ");
        int bookId = Integer.parseInt(userInput.nextLine());

        if (bookId >= 1 && bookId <= bookCount && books[bookId - 1].isCheckedOut())
        {
            books[bookId - 1].checkIn();
            System.out.println("The book was successfully checked in!");
            System.out.println("Redirecting you back to the home page now...");
        }
        else
        {
            System.out.println("Invalid book ID or the book is not currently checked out.");
            System.out.println("Redirecting you back to the home page now...");
        }
    }
}