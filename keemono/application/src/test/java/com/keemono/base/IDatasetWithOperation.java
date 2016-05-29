package com.keemono.base;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

/**
 * Created by edu on 31/10/2015.
 */
public interface IDatasetWithOperation {

    DatabaseOperation getOperation();

    IDataSet getDataset() throws Exception;

    void executeOperation(IDatabaseConnection connection) throws Exception;
}
