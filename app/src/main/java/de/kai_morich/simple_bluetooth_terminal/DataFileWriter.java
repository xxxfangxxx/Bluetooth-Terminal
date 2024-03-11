package de.kai_morich.simple_bluetooth_terminal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFileWriter {

    public static void saveDataToFile(String data, String fileType) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "received_data_" + timestamp + "." + fileType;
        String filePath = getFilePath(fileName);
        try {
            FileWriter writer = new FileWriter(filePath, true); // Append mode
            writer.append(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String fileName) {
        // Save to the Downloads directory
        String directoryPath = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        return directoryPath + File.separator + fileName;
    }

}
