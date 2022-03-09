package org.dbos.apiary.procedures.voltdb;

import org.dbos.apiary.voltdb.VoltApiaryProcedure;
import org.voltdb.SQLStmt;
import org.voltdb.VoltTable;

import java.lang.reflect.InvocationTargetException;

public class InsertMnistFunction extends VoltApiaryProcedure {

    public final SQLStmt addResult = new SQLStmt(
            // PKEY, ID, CLASSIFICATION
            "UPSERT INTO MnistClassifications VALUES (?, ?, ?);"
    );

    public VoltTable[] run(int pkey, VoltTable voltInput) throws InvocationTargetException, IllegalAccessException {
        return super.run(pkey, voltInput);
    }

    public String runFunction(Integer[] classifications) {
        for (int i = 0; i < classifications.length; i++) {
            funcApi.apiaryExecuteUpdate(addResult, 0, i, classifications[i]);
        }

        return "Successfully inserted classifications.";
    }
}