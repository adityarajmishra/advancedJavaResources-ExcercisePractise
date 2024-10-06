package com.skillovilla.java_advanced.lab4.level2;

import java.io.*;

public class DeviceDataSaver {
    public void saveDeviceData(Device device,String filePath) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(filePath)){
            ObjectOutputStream srz = new ObjectOutputStream(fos);
            srz.writeObject(device);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

class DeviceDataLoader{
    public Device loadDeviceData(String filePath) throws IOException{
        Device output = null;
        try(FileInputStream fis = new FileInputStream(filePath)){
                ObjectInputStream desrz = new ObjectInputStream(fis);
                 output =(Device) desrz.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
            return output;
        }
    }

