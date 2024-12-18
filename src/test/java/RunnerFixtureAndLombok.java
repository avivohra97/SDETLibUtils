import Fixtures.Author;
import Fixtures.Book;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import java.text.SimpleDateFormat;
import java.util.List;

public class RunnerFixtureAndLombok {
    public static void main(String[] args) {
        Fixture.of(Author.class).addTemplate("valid", new Rule() {{
            add("firstName", firstName());
            add("lastName", lastName());
            add("email", "${firstName}.${lastName}@email.com");
        }});

        Fixture.of(Book.class).addTemplate("valid", new Rule() {{
            add("id", random(Long.class, range(1L, 200L)));
            add("authors", has(2).of(Author.class, "valid"));
            add("title", regex("[A-Z]{1}[A-Z a-z]{9,29}"));
            add("created", afterDate("2017-06-22", new SimpleDateFormat("yyyy-MM-dd")));
        }});


        Book oneBook = Fixture.from(Book.class).gimme("valid");
        System.out.println(oneBook);
        List<Book> twentyBooks = Fixture.from(Book.class).gimme(20, "valid");
        System.out.println(twentyBooks.size()==20);

        twentyBooks.forEach(System.out::println);
    }

}
