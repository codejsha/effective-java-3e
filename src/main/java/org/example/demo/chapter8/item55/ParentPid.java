package org.example.demo.chapter8.item55;

// Avoiding unnecessary use of Optional's isPresent method (Page 252)
class ParentPid {
    public static void main(String[] args) {
        var ph = ProcessHandle.current();

        // Inappropriate use of isPresent
        var parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // Equivalent (and superior) code using orElse
        System.out.println("Parent PID: " +
                ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }
}
