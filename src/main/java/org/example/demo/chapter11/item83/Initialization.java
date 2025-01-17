package org.example.demo.chapter11.item83;

// Initialization styles - Pages 333-
class Initialization {

    // Normal initialization of an instance field4 - Page 282
    private final FieldType field1 = computeFieldValue();

    // Lazy initialization of instance field4 - synchronized accessor - Page 333
    private FieldType field2;
    // Double-check idiom for lazy initialization of instance fields - Page 334
    private volatile FieldType field4;
    // Single-check idiom - can cause repeated initialization! - Page 334
    private volatile FieldType field5;

    private static FieldType getField() {
        return FieldHolder.field;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }

    private synchronized FieldType getField2() {
        if (field2 == null)
            field2 = computeFieldValue();
        return field2;
    }

    // NOTE: The code for this method in the first printing had a serious error (see errata for details)!
    private FieldType getField4() {
        var result = field4;
        if (result != null)    // First check (no locking)
            return result;

        synchronized (this) {
            if (field4 == null) // Second check (with locking)
                field4 = computeFieldValue();
            return field4;
        }
    }

    private FieldType getField5() {
        var result = field5;
        if (result == null)
            field5 = result = computeFieldValue();
        return result;
    }

    // Lazy initialization holder class idiom for static fields - Page 334
    private static class FieldHolder {
        private static final FieldType field = computeFieldValue();
    }
}
