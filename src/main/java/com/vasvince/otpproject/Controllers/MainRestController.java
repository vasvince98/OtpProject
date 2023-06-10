package com.vasvince.otpproject.Controllers;


import com.vasvince.otpproject.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class MainRestController {

    private final HistoryService historyService;

    @Autowired
    public MainRestController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @GetMapping("/getNumbers")
    public String getNumbers() {
        return historyService.getHistory();
    }

    @PostMapping("/recursiveListing")
    public int recursiveListing(@RequestParam String extension) {
        File rootDir = new File("/var");
        int numberOfFiles = historyService.extensionCounter(rootDir, extension);
        historyService.addToHistory(numberOfFiles, extension);
        return numberOfFiles;
    }
}
