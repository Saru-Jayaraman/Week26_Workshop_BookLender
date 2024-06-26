package se.lexicon.model;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        setTitle(title);
        setAuthor(author);
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        setTitle(title);
        setAuthor(author);
        setBorrower(borrower);
        this.available = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        validateInput(title, "Title");
        this.title = title;
    }

    public void setAuthor(String author) {
        validateInput(author, "Author");
        this.author = author;
    }

    public void setBorrower(Person borrower) {
        available = (borrower == null);
        this.borrower = borrower;
    }

    private void validateInput(String paramName, String paramFullName) {
        if (paramName == null || paramName.trim().isEmpty()) {
            throw new IllegalArgumentException(paramFullName + " is either null nor empty");
        }
    }

    public String getBookInformation() {
        String bookDetails = "BOOK ID: " + getId() + " TITLE: " + getTitle() + " AUTHOR: " + getAuthor();
        if (!available) {
            bookDetails = bookDetails + " ---------is borrowed by--------- " + borrower.getPersonInformation();
        } else {
            bookDetails = bookDetails + " -------------------------------- " + "Not borrowed by anyone...";
        }
        return bookDetails;
    }
}