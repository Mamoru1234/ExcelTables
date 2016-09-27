package org.example.excel_interaction;

import lombok.Builder;
import lombok.Data;

/**
 * Created by alexei on 05.08.16.
 */

@Builder
@Data
public class Person {
    private String name;
    private String surname;
    private String position;
}
