package org.dbos.apiary.procedures.postgres.crossdb;

import org.dbos.apiary.postgres.PostgresContext;
import org.dbos.apiary.postgres.PostgresFunction;

import java.sql.SQLException;

public class PostgresIndexPerson extends PostgresFunction {

    private static final String insert = "INSERT INTO PersonTable(Name, Number) VALUES (?, ?) ON CONFLICT (Name) DO UPDATE SET Number = EXCLUDED.Number;";

    public static int runFunction(PostgresContext ctxt, String name, int number) throws SQLException {
        ctxt.apiaryCallFunction("ElasticsearchIndexPerson", name, number);
        ctxt.executeUpdate(insert, name, number);
        return number;
    }
}