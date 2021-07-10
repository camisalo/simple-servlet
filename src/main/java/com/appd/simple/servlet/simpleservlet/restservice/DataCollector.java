package com.appd.simple.servlet.simpleservlet.restservice;

public class DataCollector {

    private String file = "{“query”:“{ user_credentials(login:\\“79260016172\\“) {login}}“}";


    public DataCollector(String one, String second) {
        System.out.println("Constructor: " + one);
        System.out.println("Constructor: " + second);

    }

    public void openHugeFile() {
        StringHolder stringHolder = new StringHolder();
        this.readFile(file);
    }


    public void readFile(String a) {
        if (a != null ) {
            System.out.println("A");
            System.out.println(a);

//            System.out.println(a.getHolder());
        }
    }
}
