package org.reporter;

public class Main {

    public static void main(String argv[]) throws Exception {
        org.apache.camel.spring.Main springMain  = new org.apache.camel.spring.Main();
        springMain.enableHangupSupport();
        springMain.run();
    }

}
