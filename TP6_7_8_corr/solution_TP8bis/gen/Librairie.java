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

    public String toString() {
        String out  = "Librairie :";
        for (String code : elements.keySet()) {
            out += code + " :: " + elements.get(code) + "\n";
        }
        return out;
    }

    public void listing() {
        System.out.println(this);
    }

    public Map<String,E> getElements() {
        return elements;
    }
}
