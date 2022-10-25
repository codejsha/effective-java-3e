package org.example.demo.chapter4.item19;

// Class whose constructor invokes an overridable method. NEVER DO THIS! (Page 95)
class Super {
    // Broken - constructor invokes an overridable method
    Super() {
        overrideMe();
    }

    void overrideMe() {
    }
}
