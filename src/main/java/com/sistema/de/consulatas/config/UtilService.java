package com.sistema.de.consulatas.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class UtilService {

    public static Boolean uploadFile(MultipartFile fileData, String dirPath, String fileName) {
        try{

            byte[] btDataFile = fileData.getBytes();
            File file = new File(dirPath);
            if(!file.exists())
                file.mkdir();

            file = new File( dirPath + "/" + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            stream.write(btDataFile);
            stream.close();

            return true;
        }
        catch(Exception e){
            System.err.println(e.getMessage() + e.getStackTrace());
            return false;
        }
    }

    public static Boolean isValidFile(MultipartFile file, Long minSize, Long maxSize, List<String> extension){

//        logger.info("Utility.isValidFile: Started");

        if(file.getContentType() != null && file.getSize() > minSize && file.getSize() <= maxSize){
            String ext = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
            if(extension.stream().filter(fileExt -> fileExt.equalsIgnoreCase(ext)).findAny().isPresent()) return true;
        }
//        logger.info("Utility.isValidFile: Invalid File");
        return false;
    }

    public static byte[] fetchImageFromDirectory(String filename, String dirPath) {

        try{
            File file = new File(dirPath + filename);
            return Files.readAllBytes(file.toPath());
        }
        catch(Exception e){
//            logger.error("Utility.fetchImageFromDirectory: File Not Found On Server");
        }
        return null;
    }

    public static void deleteFileIfExist(String dirPath, String fileName){
        try{
//            logger.info("Utility.deleteFileIfExist: Started");
            File file = new File( dirPath + fileName);
            Files.deleteIfExists(file.toPath());
        }
        catch(Exception e){
//            logger.error("Error in deleting image. " + e.getMessage());
        }
    }
}
