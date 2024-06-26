package se.lexicon.model;

import java.util.Arrays;

public class Person {
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private Book[] booksOwned;

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
        this.booksOwned = new Book[0];
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        validateInput(firstName, "First Name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateInput(firstName, "Last Name");
        this.lastName = lastName;
    }

    private int getNextId() {
        return ++sequencer;
    }

    private void validateInput(String paramName, String paramFullName) {
        if(paramName == null || paramName.trim().isEmpty()) {
            throw new IllegalArgumentException(paramFullName + " is either null nor empty");
        }
    }

    public void loanBook(Book book) {
        if(book == null)
            throw new IllegalArgumentException("Book details cannot be null...");
        booksOwned = Arrays.copyOf(booksOwned, booksOwned.length+1);
        booksOwned[booksOwned.length-1] = book;
        book.setBorrower(this);
    }

    public void returnBook(Book book) {
        if(book == null)
            throw new IllegalArgumentException("Book details cannot be null...");
        int i = 0;
        int bookIndexToRemove = 0;
        for(Book arr : booksOwned) {
            if(arr == book) {
                bookIndexToRemove = i;
                break;
            }
            i++;
        }
        Book[] newBooksOwned = new Book[booksOwned.length-1];
        if(bookIndexToRemove != 0) {
            newBooksOwned = Arrays.copyOf(booksOwned, bookIndexToRemove-1);
//            if (newBooksOwned.length - (bookIndexToRemove + 1) >= 0)
                System.arraycopy(booksOwned, bookIndexToRemove + 1, newBooksOwned,
                        bookIndexToRemove + 1 - 1, newBooksOwned.length - (bookIndexToRemove + 1));
            booksOwned = newBooksOwned;
            book.setBorrower(null);
        } else {
            System.out.println("Book not found in the Owned Book list...");
        }
    }

    public String getPersonInformation() {
        return "PERSON ID: " + getId() + " NAME: " + getFirstName() + " " + getLastName();
    }
}