package com.projectx.springdata.repository.queryrewriter;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.QueryRewriter;

public class CustomQueryRewriter implements QueryRewriter {

    @Override
    public String rewrite(String query, Sort sort) {
        return query.replaceAll("person_table", "Person");
    }
}
