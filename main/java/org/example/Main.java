package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;
public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        File fileToReadIn = new File("src/randomGeneratedWords.txt");
        List<String> fileContents = FileUtils.readLines(fileToReadIn, "UTF-8");

        //count unique words in file and write to file using a hashset
        Set<String> frequency = new HashSet<>();
        for(String lines : fileContents){
            if(lines.contains("")) {
                String[] words = StringUtils.split(lines," ");
                for (String word : words) {
                    String symbolsInFile = word.toLowerCase()
                            .replace(",", "")
                            .replace(".", "")
                            .replace(":", "")
                            .replace("\"", "");
                    frequency.add(symbolsInFile);
                }
            }
        }
        LOGGER.info("Number of unique words: " + frequency.size());
    }
}