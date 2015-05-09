package com.keemono.domain.mongo.page;

import com.keemono.domain.mongo.base.AbstractDocument;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by edu on 09/05/2015.
 */
@Document(collection="htmlpages")
public class Layout extends AbstractDocument {
}
