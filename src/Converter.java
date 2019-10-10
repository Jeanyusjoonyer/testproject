
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class Converter {

    public static File crimeData, convertedFile, myTextFile;

    public static void main(String[] args) {

        /*
        Map systemProperties = System.getProperties();

        Set propertyKeys = systemProperties.keySet();

        for(Object key : propertyKeys){
            System.out.println(key + ": " + systemProperties.get(key));
        }
        */

        crimeData = new File("crimeData.txt");
        convertedFile = new File("covertedFile.txt");
        myTextFile = new File("myTextFile.txt");

        if(!myTextFile.exists()) {
            try {
                convertedFile.createNewFile();
                myTextFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try (FileReader myFileReader = new FileReader(crimeData); BufferedReader myLineReader = new BufferedReader(myFileReader)){

            String line;
            int attributes = 0;
            String [] var;

            //Set Mark to Recognize the Beginning of the Document
            myLineReader.mark(1);

            // Find out which attributes the File has and put them into a variable
            for (String substring : myLineReader.readLine().split(",")) {
                attributes++;
                System.out.println(attributes);
            }

            // Go to the beginning of the document
            myLineReader.reset();


            var = new String [attributes];
            var = myLineReader.readLine().split(",");

            for (int i = 0; i < var.length; i++){
                System.out.println(var[i]);
            }



            try (FileWriter myFileWriter = new FileWriter(convertedFile, false) ){

                for(int i = 0; i < var.length; i++) {
                    myFileWriter.write(var[i] +"\n");
                }



            }catch(IOException e){
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void coverter (File input){
        try (FileReader myFileReader = new FileReader(input); BufferedReader myLineReader = new BufferedReader(myFileReader)){
            String line;
            while ((line = myLineReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
