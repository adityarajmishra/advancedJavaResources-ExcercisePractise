package com.skillovilla.java_advanced.lab4.level3;

import java.io.*;

public class PaymentTransactionSerializer {
    public void serializeTransaction(PaymentTransaction transaction,String filename) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(filename)){
            ObjectOutputStream srz = new ObjectOutputStream(fos);
            srz.writeObject(transaction);
        }catch (IOException i){
            i.printStackTrace();
        }
    }
}

class PaymentTransactionDeserializer{
    public PaymentTransaction deserializeTransaction(String filename) throws IOException{
        PaymentTransaction output = null;
        try(FileInputStream fis = new FileInputStream(filename)){
            ObjectInputStream desrz = new ObjectInputStream(fis);
            output = (PaymentTransaction) desrz.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
            return output;
    }
}
