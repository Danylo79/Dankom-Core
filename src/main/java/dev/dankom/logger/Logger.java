package dev.dankom.logger;

import dev.dankom.util.general.ColorUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {

    private List<String> log;

    public Logger() {
        this.log = new ArrayList<>();
    }

    public void info(String loc, Object msg) {
        log(LogLevel.INFO, loc, msg);
    }

    public void warning(String loc, Object msg) {
        log(LogLevel.WARNING, loc, msg);
    }

    public void error(String loc, Object msg) {
        log(LogLevel.ERROR, loc, msg);
    }

    public void important(String loc, Object msg) {
        log(LogLevel.IMPORTANT, loc, msg);
    }

    public void test(String loc, Object msg) {
        log(LogLevel.TEST, loc, msg);
    }

    public void fatal(String loc, Object msg) {
        log(LogLevel.FATAL, loc, msg);
    }

    public void log(LogLevel level, String loc, Object msg) {
        Date date = new Date();
        String time = "[" + date.getHours() + ":" + date.getMinutes() + "." + date.getSeconds() + "]";
        loc = "[" + loc + "]";
        String print = level.getColor() + time + " [" + level.getName() + "] " + loc + " " + msg + ColorUtil.ANSI_RESET;
        System.out.println(print);
        log.add(print);
    }

    public List<String> logs() {
        return log;
    }
}