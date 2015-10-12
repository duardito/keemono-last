package com.keemono.common.mapper;

import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class CustomBaseMapper<A,B> extends CustomMapper <A,B>{

	private Map<String, String> fields;
    private List<String> excludes;

    public CustomBaseMapper() {
        super();
        fields = new HashMap<>();
        excludes = new ArrayList<>();
    }

    public void addField(String fieldA, String fieldB) {
        fields.put(fieldA, fieldB);
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void addExclude(String field) {
        excludes.add(field);
    }

    public List<String> getExcludes() {
        return excludes;
    }

}
