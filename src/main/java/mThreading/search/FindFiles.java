package mThreading.search;

import org.apache.log4j.Logger;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

import static java.nio.file.FileVisitResult.*;

public class FindFiles extends SimpleFileVisitor<Path> {
    final static Logger logger = Logger.getLogger(FindFiles.class);
    private final List<String> exts;
    private ConcurrentLinkedQueue<Path> files;
    private Object monitor;

    public FindFiles(List<String> exts, ConcurrentLinkedQueue<Path> files, Object monitor) {
        this.exts = exts;
        this.files = files;
        this.monitor = monitor;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isRegularFile()) {
            logger.info("find: checking extenstion of file:" + file.toString());
            if ( exts.stream().anyMatch(obj -> file.toString().endsWith("." + obj))) {
                synchronized (monitor) {
                    logger.info("adding file:" + file.toString());
                    files.add(file);
                    monitor.notify();
                }
            }
        }
        return CONTINUE;
    }


}
