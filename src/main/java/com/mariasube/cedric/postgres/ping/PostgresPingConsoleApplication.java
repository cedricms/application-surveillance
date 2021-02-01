package com.mariasube.cedric.postgres.ping;


import com.mariasube.cedric.postgres.ping.service.PostgresPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresPingConsoleApplication implements CommandLineRunner  {

    @Autowired
    private PostgresPingService postgresPingService;

    public static void main(String[] args) throws Exception {
        // Disables the banner in order to hide the spring logo
        SpringApplication app = new SpringApplication(PostgresPingConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        postgresPingService.run();

        System.exit(0);
    }
}
