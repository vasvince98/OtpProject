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


    @GetMapping("/history")
    public String history() {
        return historyService.getHistory();
    }

    @PostMapping("/getUniqueNames")
    public int getUniqueNames(@RequestParam String extension) {
        //todo: check other folders
        File rootDir = new File("/var");
        int numberOfFiles = historyService.extensionCounter(rootDir, extension);
        historyService.addToHistory(numberOfFiles, extension);
        return numberOfFiles;
    }
}
