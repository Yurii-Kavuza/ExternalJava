package ua.external.base.oop.droid.serialization;

import ua.external.base.oop.droid.droids.Droid;

import java.io.*;
import java.util.ArrayList;

public class DroidsSerialization
{
    private static final String pathToBinaryFile = "SerializedDroids.bin";
    private static final String pathToCsvFile = "SerializedDroids.csv";

    public static void writeDroidsToBinaryFile(ArrayList<Droid> warriors)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(pathToBinaryFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(warriors);
            fos.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeDroidsToTextFile(ArrayList<Droid> warriors)
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(pathToCsvFile);

            for(Droid droid: warriors)
            {
                printWriter.println(droid.toString());
            }

            printWriter.flush();
            printWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
