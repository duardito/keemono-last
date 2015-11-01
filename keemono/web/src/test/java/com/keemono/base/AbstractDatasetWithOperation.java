package com.keemono.base;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.operation.DatabaseOperation;

/**
 * Created by edu on 31/10/2015.
 */
public abstract class AbstractDatasetWithOperation implements IDatasetWithOperation {

    private DatabaseOperation databaseOperation;

    @Override
    public DatabaseOperation getOperation() {
        return databaseOperation;
    }

    public void setOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    @Override
    public void executeOperation(IDatabaseConnection connection) throws Exception {
        getOperation().execute(connection, getDataset());
    }
}
