package com.keemono.common.converter.base;

/**
 * Created by edu on 02/01/2016.
 */
public class ContentBuilder {

    protected static final String LEFT_CURLY_BRACKET = "{";
    protected static final String RIGHT_CURLY_BRACKET = "}";
    protected static final String LEFT_SQUARE_BRACKET = "[";
    protected static final String RIGHT_SQUARE_BRACKET = "]";
    protected static final String STRAIGHT_DOUBLE_QUOTE = "\"";
    protected static final String COMMA = ",";
    protected static final String COLON = ":";
    protected static final String BACKSLASH = "\\";

    protected StringBuilder content;

    public ContentBuilder() {
        content = new StringBuilder();
    }

    public static String escape(String str) {
        return str.replace(STRAIGHT_DOUBLE_QUOTE, BACKSLASH + STRAIGHT_DOUBLE_QUOTE);
    }

    public String build() {
        content.setLength(content.length() > 0 ? content.length() - 1 : 0);

        StringBuilder result = new StringBuilder();
        result.append(LEFT_CURLY_BRACKET)
                .append(content)
                .append(RIGHT_CURLY_BRACKET);

        return result.toString();
    }

    public ContentBuilder addField(String key, String value) {
        content.append(createKeyValue(key, value));
        return this;
    }

    public ContentBuilder addJsonField(String key, String jsonContent) {
        if (jsonContent != null) {
            jsonContent = jsonContent.substring(1, jsonContent.length() - 1);
        }
        content.append(createKeyValueWithCurlyBrackets(key, jsonContent));
        return this;
    }

    public ContentBuilder addJsonArray(String key, String jsonContent) {
        content.append(createKeyValueArray(key, jsonContent));
        return this;
    }

    protected static StringBuilder createKeyValue(String key, String value) {
        if (value == null) {
            return createKeyValueNull(key, value);
        }

        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(STRAIGHT_DOUBLE_QUOTE)
                .append(escape(value))
                .append(STRAIGHT_DOUBLE_QUOTE).append(COMMA);
        return keyValue;
    }

    protected static StringBuilder createKeyValueWithoutDoubleQuote(String key, String value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value).append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValueBoolean(String key, Boolean value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value)
                .append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValueNull(String key, String value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value)
                .append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValueArray(String key, String value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value)
                .append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValue(String key, Integer value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value)
                .append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValue(String key, Long value) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(value)
                .append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValue(String key, String[] values) {
        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON);
        keyValue.append(LEFT_SQUARE_BRACKET);
        for (String value : values) {
            keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                    .append(value)
                    .append(STRAIGHT_DOUBLE_QUOTE)
                    .append(COMMA);
        }

        keyValue.setLength(keyValue.length() - 1);

        keyValue.append(RIGHT_SQUARE_BRACKET).append(COMMA);

        return keyValue;
    }

    protected static StringBuilder createKeyValueWithCurlyBrackets(String key, String value) {
        if (value == null) {
            return createKeyValueNull(key, value);
        }

        StringBuilder keyValue = new StringBuilder();
        keyValue.append(STRAIGHT_DOUBLE_QUOTE)
                .append(key)
                .append(STRAIGHT_DOUBLE_QUOTE).append(COLON)
                .append(LEFT_CURLY_BRACKET)
                .append(value)
                .append(RIGHT_CURLY_BRACKET).append(COMMA);

        return keyValue;
    }

    public static ContentBuilder aContent() {
        return new ContentBuilder();
    }
}
