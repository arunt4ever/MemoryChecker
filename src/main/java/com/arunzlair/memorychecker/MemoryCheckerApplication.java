package com.arunzlair.memorychecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@SpringBootApplication
public class MemoryCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoryCheckerApplication.class, args);
        printmemory();
    }

    private static void printmemory() {
        int mb = 1024 * 1024;
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long xmx = memoryBean.getHeapMemoryUsage().getMax() / mb;
        long xms = memoryBean.getHeapMemoryUsage().getInit() / mb;
        System.out.println("Initial Memory (xms) : "+ xms+" mb");
        System.out.println("Max Memory (xmx) : "+ xmx+" mb");
    }

}
