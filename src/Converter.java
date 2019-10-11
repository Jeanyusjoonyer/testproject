
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class Converter {

    public static File crimeData, convertedFile, myTextFile;

    public static void main(String[] args) {

        //Create and Designate the Files
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
        try02();
    }

    public static void try02(){
        try (FileReader myFileReader = new FileReader(crimeData); BufferedReader myLineReader = new BufferedReader(myFileReader)){

            String line;
            int attributes = 0;
            String [] tagName;
            String [] TagValue;

            //Set Mark to Recognize the Beginning of the Document
            myLineReader.mark(1);
            // Find out which attributes the File has and put them into a variable
            for (String substring : myLineReader.readLine().split(",")) {
                attributes++;
                System.out.println(attributes);
            }
            // Go to the beginning of the document
            myLineReader.reset();

            ArrayList<String> list = new ArrayList<String>();
            line = myLineReader.readLine();

            System.out.println(line);

            try (FileWriter myFileWriter = new FileWriter(convertedFile,false)){
                myFileWriter.write(line);
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

    public static void try01 (){
        try (FileReader myFileReader = new FileReader(crimeData); BufferedReader myLineReader = new BufferedReader(myFileReader)){

            String line;
            int attributes = 0;
            String [] tagName;
            String [] TagValue;

            //Set Mark to Recognize the Beginning of the Document
            myLineReader.mark(1);

            // Find out which attributes the File has and put them into a variable
            for (String substring : myLineReader.readLine().split(",")) {
                attributes++;
                System.out.println(attributes);
            }

            // Go to the beginning of the document
            myLineReader.reset();


            tagName = new String [attributes-1];
            tagName = myLineReader.readLine().split(",");

            for (int i = 0; i < tagName.length; i++){
                System.out.println(tagName[i]);
            }

            try (FileWriter myFileWriter = new FileWriter(convertedFile, false) ){

                TagValue = new String [attributes-1];


                while ((line = myLineReader.readLine()) != null) {
                    TagValue = myLineReader.readLine().split(",");
                    myFileWriter.write("crime ");
                    for (int i = 0; i < tagName.length; i++) {
                        myFileWriter.write(tagName[i] + "="  + TagValue[i] + " ");
                    }
                    myFileWriter.write("\n");
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

}
