package org.facebook.util;

import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by GALIB on 3/15/2015.
 */
public class FileUtils {

    public static String VIEWS_PATH = "views";
    public static String RESOURCES_PATH = VIEWS_PATH + File.separator +"resources";
    public static String UPLOADS_PATH = RESOURCES_PATH + File.separator + "uploads";
    public static String PHOTOES_PATH = UPLOADS_PATH + File.separator + "photoes";

    public static void writePartToFile(Part filePart, String contextPath,String fileName) throws IOException {
        OutputStream out = null;
        InputStream filecontent = null;
        String fileUrl = contextPath +File.separator+ PHOTOES_PATH + File.separator + fileName;

        try {
            out = new FileOutputStream(new File(fileUrl));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (Exception ex) {

        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }

}
