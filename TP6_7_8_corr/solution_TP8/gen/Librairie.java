package gen;

import java.util.*;
import java.io.*;

public class Librairie<E> {
    protected Map<String,E> elements = new TreeMap<String,E>();

    public void add(String code, E o) {
        elements.put(code,o);
    }

    public E get(String code) {
        return elements.get(code);
    }

    public void listing() {
        System.out.println("Librairie :");
        for (String code : elements.keySet()) {
            System.out.println(code + " :: " + elements.get(code));
        }
    }
}
