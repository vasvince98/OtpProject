package com.vasvince.otpproject.Controllers;


import com.vasvince.otpproject.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@RestController
public class MainRestController {

    private final HistoryService historyService;

    @Autowired
    public MainRestController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @GetMapping("/history")
    public String history() {
        return historyService.getHistory();
    }

    @PostMapping("/getUniqueNames")
    public int getUniqueNames(@RequestParam String extension) {
        // /var, /usr,
        File rootDir = new File("/");
        Set<String> fileNames = new HashSet<>();
        int numberOfFiles = historyService.extensionCounter(rootDir, extension, fileNames);
        historyService.addToHistory(numberOfFiles, extension);
        return numberOfFiles;
    }
}
