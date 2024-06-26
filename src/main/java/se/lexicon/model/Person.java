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
        int bookIndexToRemove = -1;
        for (int i = 0; i < booksOwned.length; i++) {
            if (booksOwned[i].equals(book)) {
                bookIndexToRemove = i;
                break;
            }
        }
        if(bookIndexToRemove != -1) {
            Book[] newBooksOwned = new Book[booksOwned.length-1];
            for (int j = 0; j < bookIndexToRemove; j++) {
                newBooksOwned[j] = booksOwned[j];
            }
            for(int j=bookIndexToRemove, k=bookIndexToRemove+1; j<booksOwned.length && k<=newBooksOwned.length; j++, k++) {
                newBooksOwned[j] = booksOwned[k];
            }
            booksOwned = newBooksOwned;
            book.setBorrower(null);
            String bookReturnDetails;
            for(int k=0; k<booksOwned.length; k++) {
                bookReturnDetails = booksOwned[k].getBookInformation();
                System.out.println(k + " " + bookReturnDetails);
            }
            System.out.println();
        } else {
            throw new IllegalArgumentException("Book not found...");
        }
    }

    public String getPersonInformation() {
        return "PERSON ID: " + getId() + " NAME: " + getFirstName() + " " + getLastName();
    }
}