package org.example.generator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by alexei on 05.08.16.
 */
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Person {
    @Getter private final String name;
    @Getter private final String surname;
    @Getter private final String position;
}
