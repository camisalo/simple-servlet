package com.appd.simple.servlet.simpleservlet.restservice;

import com.appdynamics.agent.api.AppdynamicsAgent;
import com.appdynamics.agent.api.EntryTypes;
import com.appdynamics.agent.api.Transaction;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong other_counter = new AtomicLong();

    @GetMapping("/api/v1/4829573/first")
    public Greeting greeting_1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/api/v1/3252351/second")
    public ResponseEntity<Object> greeting_2(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {
        int ran = new Random().nextInt(6);

        System.out.println("URL: /api/v1/3252351/second");
        errorThrower("AAA: TEST");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping("/api/v1/8392753/third")
    public Greeting greeting_3(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/api/v1/3948273/fourth")
    public Greeting greeting_4(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("/test")
    public String test() throws UnirestException {
        int ran = new Random().nextInt(6);
        String url;
        if (ran == 0) {
            url = "http://localhost:8081/api/v1/4829573/first?name=konrad";
        } else if (ran == 1) {
            url = "http://localhost:8081/api/v1/3252351/second?name=Alicja";
        } else if (ran == 2) {
            url = "http://localhost:8081/api/v1/8392753/third?name=Justyna";
        } else if (ran ==3) {
            url = "http://localhost:8081/api/v1/3948273/fourth?name=Adamenczykin";
        } else {
            url = "http://localhost:8081/api/v1/anakin/wyszydlo";
        }

        System.out.println(url);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(url)
            .asString();

        return response.getBody();
    }

    @GetMapping("/")
    public Greeting greetingSlash(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(other_counter.incrementAndGet(),String.format(template, name));
        long ala = greeting.getId();
        DataCollector dataCollector = new DataCollector("1","2");
        dataCollector.openHugeFile();
        greeting.setId(ala + 5);
        this.getTest(greeting);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/api/v1")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        try (Transaction transaction = AppdynamicsAgent.startTransaction("API-test", null, EntryTypes.POJO, false)) {

            Greeting greeting = new Greeting(other_counter.incrementAndGet(), String.format(template, name));
            long ala = greeting.getId();
            DataCollector dataCollector = new DataCollector("1","2");
            dataCollector.openHugeFile();
            greeting.setId(ala + 5);
            this.getTest(greeting);
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
    }

    @GetMapping("/api/v2/domains/pn/dpi/profile/customer@plusdsl.net")
    public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    @GetMapping("greeting")
    public Greeting greeting3(@RequestParam(value = "name", defaultValue = "World") String name) {


        SomeClassXD someClassXD = new SomeClassXD();

        VuxTest vuxTest = new VuxTest();

        vuxTest.loadMicroApplication(someClassXD);

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("commercial-cpm/v1/claim/{claimId}")
    public Greeting greeting4(@PathParam(value = "claimId") String orderId) {
        return new Greeting(counter.incrementAndGet(), String.format(template, orderId));
    }

    @PostMapping("/post")
    public Greeting post(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://www.google.pl/")
            .header("Cookie", "1P_JAR=2020-09-11-12; NID=204=e63PZgiHhO-agyz58D2R0jwRSB68rKRqSPrWBhHe1KU-IDsAhi9acYaPHwH653OliVmz4re53VNr0m4k7Unz-yowI2wxqn5mL_queNj12uhlpJfSegM21edvHkD2ckTKk26BbQlt786WVnZqch72BfWeV0TCinWF58f9bkbAW84")
            .asString();

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/go")
    public ResponseEntity google(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.google.pl/")
                .asString();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/error_thrower")
    public ResponseEntity errorThrower(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {
        if (new Random().nextBoolean()) {
            String[] strArray = new String[]{"John", "Snow"};
            ArrayList<String> strList = (ArrayList<String>) Arrays.asList(strArray);
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://www.google.pl/")
                    .header("Cookie", "1P_JAR=2020-09-11-12; NID=204=e63PZgiHhO-agyz58D2R0jwRSB68rKRqSPrWBhHe1KU-IDsAhi9acYaPHwH653OliVmz4re53VNr0m4k7Unz-yowI2wxqn5mL_queNj12uhlpJfSegM21edvHkD2ckTKk26BbQlt786WVnZqch72BfWeV0TCinWF58f9bkbAW84")
                    .asString();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/error_thrower_2")
    public ResponseEntity errorThrower2(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {
        if (new Random().nextBoolean()) {
            logger.error("Some Exception that I would like to detect");
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/error_thrower_3")
    public ResponseEntity errorThrower3(@RequestParam(value = "name", defaultValue = "World") String name) throws UnirestException {
        if (new Random().nextBoolean()) {
            logger.error("Some Exception that I would like to detect", new NoSuchFieldException());
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    public void getTest(Greeting greeting) {
        System.out.println(greeting);
    }
}