package com.keemono.base;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;

/**
 * Created by edu on 31/10/2015.
 */
public class SimpleDatasetWithOperation extends AbstractDatasetWithOperation {

    private String datasetPath;

    public SimpleDatasetWithOperation(String datasetPath, DatabaseOperation databaseOperation) {
        this.datasetPath = datasetPath;
        setOperation(databaseOperation);
    }

    @Override
    public IDataSet getDataset() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File(getClass().getClassLoader().getResource(datasetPath).toURI()));
    }
}