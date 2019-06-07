package com.belle.springsecurityjwt.model.entity;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Test {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<Test> tests;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Test test=(Test) o;
        return Objects.equals (name, test.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash (name);
    }
}
