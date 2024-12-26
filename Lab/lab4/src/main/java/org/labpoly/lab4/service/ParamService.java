package org.labpoly.lab4.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequestScope
public class ParamService {
    private final HttpServletRequest request;

    public ParamService(@Autowired HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String paramName, String defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    public int getInt(String paramName, int defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        } else {
            return Integer.parseInt(value);
        }
    }

    public double getDouble(String paramName, double defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        } else {
            return Double.parseDouble(value);
        }
    }

    public Boolean getBoolean(String paramName, boolean defaultValue) {
        String value = request.getParameter(paramName);
        if (value == null) {
            return defaultValue;
        } else {
            return true;
        }
    }

    public String getLocalDate(String paramName, String defaultDate, String pattern) {
        String dateValue = request.getParameter(paramName);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (Objects.equals(dateValue, "")) {
            LocalDate localDate = LocalDate.parse(defaultDate, formatter);
            return localDate.format(DateTimeFormatter.ofPattern(pattern));
        } else {
            LocalDate localDate = LocalDate.parse(dateValue, formatter);
            return localDate.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    public File saveFile(MultipartFile multipartFile, String appRealPath, String folderName) throws IOException {
        if(multipartFile != null) {
            File dir = new File(appRealPath+"/"+folderName); // Create File include appRealPath and folderName
            if (!dir.exists()) { // Check dir is existed?
                dir.mkdirs(); // Create folder in system
            }
            File fileSave = new File(dir, multipartFile.getOriginalFilename()); // Create File include appRealPath, folderName and multipathFile
            multipartFile.transferTo(fileSave); // Save content of File is uploaded
            return fileSave;
        } else {
            return null;
        }
    }
}
