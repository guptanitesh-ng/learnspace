package com.concepts.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class InterruptedIOExceptionCheck {

    private static Logger logger = Logger.getLogger("InterruptedIOExceptionCheck");
    /*
     * static { BasicConfigurator.configure(); }
     */

    public static void main(String[] args) {
        String log4jConfigFile = "log4j.xml";
        DOMConfigurator.configure(log4jConfigFile);
        for (int i = 1; i <= 2; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        logger.warn("A warning message");
                    }
                }
            });
            t.start();
        }
    }
}
