package spring.ku.boot.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SimplePage<T> {
    Integer total;

    Integer pages;

    List<T> elements;
}
