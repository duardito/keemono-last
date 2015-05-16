package com.keemono.core.mongo.domain.js;

import com.keemono.core.mongo.base.AbstractDocument;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by edu on 16/05/2015.
 */
@Document(collection="javascript")
public class JavaScript extends AbstractDocument {

    private String script;
    private String version;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
