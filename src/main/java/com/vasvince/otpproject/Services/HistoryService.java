package com.vasvince.otpproject.Services;

import com.google.gson.Gson;
import com.vasvince.otpproject.Entities.History;
import com.vasvince.otpproject.Repositories.IHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class HistoryService {

    private final IHistoryRepository historyRepository;

    @Autowired
    public HistoryService(IHistoryRepository testRepository) {
        this.historyRepository = testRepository;
    }


    public String getHistory() {
        //todo: remove me
        historyRepository.findAll().forEach(System.out::println);
        return new Gson().toJson(historyRepository.findAll());
    }

    public int extensionCounter(File dir, String extension, Set<String> fileNames) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                //Exclude sys and proc directories
                if (file.getName().equals("sys") || file.getName().equals("proc")) {
                    continue;
                }
                if (file.isDirectory()) {
                    System.out.println("Searching directory ... " + file.getAbsoluteFile());
                    extensionCounter(file, extension, fileNames);
                } else if (file.getName().endsWith(extension)) {
                    fileNames.add(file.getName());
                }
            }
        }
        System.out.println("Number of files with extension " + extension + " is " + fileNames.size());
        return fileNames.size();
    }

    public void addToHistory(int numberOfFiles, String extension) {
        String username;
        try {
            Process process = Runtime.getRuntime().exec("whoami");
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            username = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        historyRepository.save(new History(username, numberOfFiles, LocalDateTime.now().toString(), extension));
    }


}
