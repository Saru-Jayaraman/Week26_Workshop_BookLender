package se.lexicon;

import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion

        System.out.println("BEFORE BORROWING:");
        System.out.println("================");
        // Create a book instance
        Book bookObj1 = new Book("The Very Hungry Caterpillar", "Eric Carle");
        displayBookPersonInformation(bookObj1);
        Book bookObj2 = new Book("Five More Minutes", "Marta Altés");
        displayBookPersonInformation(bookObj2);
        Book bookObj3 = new Book("Jules Vs Ocean", "Jessie Sima");
        displayBookPersonInformation(bookObj3);
        Book bookObj4 = new Book("The Night Gardener", "Jonathan Auxier");
        displayBookPersonInformation(bookObj4);
        Book bookObj5 = new Book("Monkey Puzzle", "Julia Donaldson");
        displayBookPersonInformation(bookObj5);

        System.out.println();

        // Create a person instance
        Person personObj1 = new Person("Sarumathi", "Jayaraman");
        displayPersonInformation(personObj1);
        Person personObj2 = new Person("Pragya", "Satheeshkumar");
        displayPersonInformation(personObj2);

        System.out.println();

        System.out.println("AFTER BORROWING:");
        System.out.println("================");
        // Loan a book to the person
        personObj1.loanBook(bookObj1);
        personObj1.loanBook(bookObj2);
        personObj1.loanBook(bookObj3);
        personObj1.loanBook(bookObj4);

        // Display person information after borrowing a book
        // Display book information after borrowing a book
        displayBookPersonInformation(bookObj1);
        displayBookPersonInformation(bookObj2);
        displayBookPersonInformation(bookObj3);
        displayBookPersonInformation(bookObj4);
        displayBookPersonInformation(bookObj5);

        System.out.println("AFTER RETURNING:");
        System.out.println("===============");
        // Return the borrowed book
        personObj1.returnBook(bookObj2);
        personObj1.returnBook(bookObj1);

        // Display person information after returning the book
        // Display book information after borrowing a book
        displayBookPersonInformation(bookObj1);
        displayBookPersonInformation(bookObj2);
    }

    public static void displayBookPersonInformation(Book bookObj) {
        String printBookPersonDetails = bookObj.getBookInformation();
        System.out.println(printBookPersonDetails);
    }

    public static void displayPersonInformation(Person personObj) {
        String printPersonDetails = personObj.getPersonInformation();
        System.out.println(printPersonDetails);
    }
}
