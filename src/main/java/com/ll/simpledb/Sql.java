package com.ll.simpledb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sql {

    private final SimpleDb simpleDb;
    private final StringBuilder sqlBuilder;
    private final List<Object> params;

    public Sql(SimpleDb simpleDb) {
        this.simpleDb = simpleDb;
        this.sqlBuilder = new StringBuilder();
        this.params = new ArrayList<>();
    }

    public Sql append(String sqlPart, Object... args) {
        sqlBuilder.append(sqlPart).append(" ");
        Collections.addAll(params, args);
        return this;
    }

    public long insert() {
        String sql = sqlBuilder.toString();
        return simpleDb.runInsertAndGetGeneratedKey(sql, params.toArray());
    }
}
