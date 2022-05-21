package guru.springframework.springwebapp.bootstrap;

import guru.springframework.springwebapp.domain.Author;
import guru.springframework.springwebapp.domain.Book;
import guru.springframework.springwebapp.domain.Publisher;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;
import guru.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher manning = new Publisher("Manning", "St John Doe Street, 8999", "New York", "Dunnow", "0000420");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        manning.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(manning);

        Publisher fuctura = new Publisher("Fuctura", "St John Doe Street, 3999", "New York", "Dunnow", "0000420");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3828845724");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        fuctura.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(fuctura);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Manning number of books: " + manning.getBooks().size());
        System.out.println("Fuctura number of books: " + fuctura.getBooks().size());
    }
}
