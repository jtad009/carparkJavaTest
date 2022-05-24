import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileClass {
    public void writeToFile(int totalCars, int totalVacantSpot) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt", true);
            myWriter.write(this.report(totalCars, totalVacantSpot));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String report(int totalCars,int totalVacantSpot){
        String reportContent = "Total Number of cars in car park: {0}\n";
        reportContent += "Report Time: {1}\n";
        reportContent += "Total vacant spots: {2}\n";
        reportContent += "";
        return MessageFormat.format(reportContent, 
        totalCars, 
        this.getCurrentTime(), 
        totalVacantSpot);
    }

    /**
     * Get the current time of the system
     * 
     * @return String current systen time
     */
    private String getCurrentTime() {
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.format(cal.getTime());
    }
}
