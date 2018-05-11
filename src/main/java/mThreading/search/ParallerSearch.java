package mThreading.search;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParallerSearch {
    final static Logger logger = Logger.getLogger(ParallerSearch.class);
    private final String root;
    private final List<String> exts;
    private final String text;
    private ConcurrentLinkedQueue<Path> files = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<String> paths = new ConcurrentLinkedQueue<String>();
    private volatile Boolean isFinished = false;
    private Object monitor = new Object();

    public ParallerSearch(String root, List<String> exts, String text) {
        this.root = root;
        this.exts = exts;
        this.text = text;
    }

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                super.run();
                FindFiles findFiles = new FindFiles(exts,files, monitor);
                try {
                    Files.walkFileTree(Paths.get(root),findFiles);
                } catch (IOException e){
                    logger.error(e.getMessage());
                    isFinished = true;
                    synchronized (monitor) {
                        monitor.notify();
                    }
                }
                isFinished = true;
                synchronized (monitor)  {
                    monitor.notify();
                }
            }
        };
        Thread read = new Thread() {
            @Override
            public void run() {
                super.run();
                String filename;
                while (!isFinished) {
                    if (files.size() == 0) {
                        synchronized (monitor) {
                            try {
                                logger.info("search: waiting");
                                monitor.wait();
                            } catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    } else {

                        try {
                            logger.info("search: getting file");
                            filename = files.poll().toString();
                            logger.info("search: look into file:" + filename);
                            Scanner scan = new Scanner(new File(filename));
                            while (scan.hasNext()) {
                                String line = scan.nextLine().toLowerCase().toString();
                                if (line.contains(text.toLowerCase())) {
                                    logger.info("file:" + filename + " HAS text");
                                    paths.add(filename);
                                }
                            }
                        } catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        search.start();
        read.start();
    }


}
