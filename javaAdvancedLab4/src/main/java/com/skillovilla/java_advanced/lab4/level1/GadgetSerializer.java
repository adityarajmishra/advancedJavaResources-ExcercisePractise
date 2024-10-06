package com.skillovilla.java_advanced.lab4.level1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GadgetSerializer {

    public void serializeGadget(Gadget gadget, String filename) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(gadget);
        }
    }
}
