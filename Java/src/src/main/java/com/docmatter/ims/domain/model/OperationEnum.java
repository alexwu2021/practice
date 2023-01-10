package com.docmatter.ims.domain.model;


import java.util.HashMap;
import java.util.Map;

/**
 * following the practice of Attaching Values to Java Enum
 * https://www.baeldung.com/java-enum-values
 */
public enum OperationEnum {
    EntityView("entity-view"),
    Login("login"),
    EmailClick("email-click"),
    EmailOpen("email-open"),
    LinkClick("link-click");

    public final String label;
    private OperationEnum(String label) {
        this.label = label;
    }

    private static final Map<String, OperationEnum> BY_LABEL = new HashMap<>();

    static {
        for (OperationEnum operationEnum: values()) {
            BY_LABEL.put(operationEnum.label, operationEnum);
        }
    }


    public static OperationEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    @Override
    public String toString() {
        return this.label;
    }
}
