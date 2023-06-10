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


@Service
public class HistoryService {

    private final IHistoryRepository historyRepository;

    @Autowired
    public HistoryService(IHistoryRepository testRepository) {
        this.historyRepository = testRepository;
    }


    public String getHistory() {
        historyRepository.findAll().forEach(System.out::println);
        return new Gson().toJson(historyRepository.findAll());
    }

    public int extensionCounter(File dir, String extension) {
        int count = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Searching directory ... " + file.getAbsoluteFile());
                    count += extensionCounter(file, extension);
                } else if (file.getName().endsWith(extension)) {
                    count++;
                }
            }
        }
        return count;
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
