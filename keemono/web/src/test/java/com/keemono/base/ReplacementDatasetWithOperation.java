package com.keemono.base;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;

/**
 * Created by edu on 31/10/2015.
 */
public class ReplacementDatasetWithOperation extends AbstractDatasetWithOperation {

    private String datasetPath;
    private String replacementFlag;
    private Object replacementValue;

    public ReplacementDatasetWithOperation(String datasetPath, DatabaseOperation databaseOperation, String replacementFlag, Object replacementValue) {
        this.datasetPath = datasetPath;
        setOperation(databaseOperation);
        this.replacementFlag = replacementFlag;
        this.replacementValue = replacementValue;
    }

    @Override
    public IDataSet getDataset() throws Exception {

        ReplacementDataSet replacementDataset = new ReplacementDataSet(new FlatXmlDataSetBuilder().build(new File(getClass().getClassLoader()
                .getResource(datasetPath).toURI())));
        replacementDataset.addReplacementObject(replacementFlag, replacementValue);

        return replacementDataset;
    }

}
