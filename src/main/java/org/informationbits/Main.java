package org.informationbits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
       logger.info("Hello !!!");
       logger.info(
                "Presently, main is blank you could use respective Unit Test OR add some code here to " +
                        "run/check respective functions");
    }
}