package Fixtures;


import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private List<Author> authors = new ArrayList<>();
    private Date created;

    // getter, setter, toString ommitted...
}
