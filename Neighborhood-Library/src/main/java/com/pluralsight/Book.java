package com.pluralsight;



class Book
{
    // Properties
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // G&S
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isCheckedOut()
    {
        return isCheckedOut;
    }

    public String getCheckedOutTo()
    {
        return checkedOutTo;
    }

    // Checkout Methods
    public void checkOut(String name)
    {
        if (!isCheckedOut)
        {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("This book is now checked out to " + name + ".");

        }

        else
        {
            System.out.println("This book is already checked out.");
        }
    }

    // Check In Methods
    public void checkIn()
    {
        if (isCheckedOut)
        {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("The book has been successfully checked in!");
        }

        else
        {
            System.out.println("This book is not currently checked out.");
        }
    }

    // toString for Book info

    public String toString()
    {
        if (isCheckedOut)
        {
            return "Book ID: " + id + ", Title: " + title + ", ISBN: " + isbn + ", Checked Out: " + isCheckedOut +
                    ", Checked Out To: " + checkedOutTo;
        }

        else
        {
            return "Book ID: " + id + ", Title: " + title + ", ISBN: " + isbn + ", Checked Out: " + isCheckedOut;
        }
    }
}