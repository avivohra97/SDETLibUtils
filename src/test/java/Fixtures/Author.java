package Fixtures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String firstName;
    private String lastName;
    private String email;

    // getter, setter, toString ommitted..
}
