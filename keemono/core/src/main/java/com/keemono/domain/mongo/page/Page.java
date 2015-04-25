package com.keemono.domain.mongo.page;

import com.keemono.domain.mongo.base.AbstractDocument;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by edu on 25/4/15.
 */
@Document(collection="htmlpages")
public class Page extends AbstractDocument {

}
