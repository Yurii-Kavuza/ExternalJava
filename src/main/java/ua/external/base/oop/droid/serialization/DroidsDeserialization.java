package ua.external.base.oop.droid.serialization;

import ua.external.base.oop.droid.droids.Droid;

import java.io.*;
import java.util.ArrayList;

public class DroidsDeserialization
{
    public static final String pathBinaryToFile = "SerializedDroids.bin";
    public static final String pathToCsvFile = "SerializedDroids.csv";

    public static void readDroidsFromBinaryFile()
    {
        try
        {
            FileInputStream fis = new FileInputStream(pathBinaryToFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Droid> warriors =  (ArrayList<Droid>)ois.readObject();

            for(Droid droid: warriors)
            {
                System.out.println(droid);
            }

            fis.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readDroidsFromTextFile()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(pathToCsvFile));

            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

            reader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
