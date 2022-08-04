package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("from BootstrapData class : ");

        Author ibrahim = new Author("ibrahim","zeroual");
        Book ddd = new Book("DDD","123GGG");

        Publisher publisher = new Publisher();
        publisher.setName("Ana");
        publisher.setCity("larache");
        publisher.setState("done");

        publisherRepository.save(publisher);

        ibrahim.getBooks().add(ddd);
        ddd.getAuthors().add(ibrahim);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(ibrahim);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author kyle = new Author("kyle","simpson");
        Book ydkjs = new Book("YDKJS","155646fdffs");

        kyle.getBooks().add(ydkjs);
        ydkjs.getAuthors().add(kyle);

        ydkjs.setPublisher(publisher);
        publisher.getBooks().add(ydkjs);

        authorRepository.save(kyle);
        bookRepository.save(ydkjs);
        publisherRepository.save(publisher);



        System.out.println("numberOfBooks  "+bookRepository.count());
        System.out.println("numberOfBooksInPublisher  "+publisher.getBooks().size());
    }
}
