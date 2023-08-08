
import java.io.*;

public class UserDataValidator {
    public static void main(String[] args) {


        try {
            BufferedReader data = new BufferedReader(new FileReader("src/userValidator"));
            BufferedWriter validWriter = new BufferedWriter(new FileWriter("src/output.txt"));
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter("src/errOutput.txt"));
            String info;
            while((info = data.readLine()) != null) {
                try {
                    String[] infoArray = info.split(",");
                    if (infoArray.length > 3) {
                        throw new IllegalArgumentException("Missing Data");
                    }
                    String name = infoArray[0].trim();
                    String email = infoArray[1].trim();
                    int age = Integer.parseInt(infoArray[2].trim());
                    if (age <= 0) {
                        throw new IllegalArgumentException("Invalid Age");
                    }
                    validWriter.write(info);
                    validWriter.newLine();
                } catch (Exception e){
                errorWriter.write(info + "" + e);
                errorWriter.newLine();
                }
            }
            data.close();
            errorWriter.close();
            validWriter.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
