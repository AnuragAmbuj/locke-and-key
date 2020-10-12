package com.superlocks.collection;

import com.superlocks.structures.Semaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.out;

@Service
public class ShutdownHookCheck {

    @Qualifier("defaultBinarySemaphore")
    @Autowired
    Semaphore semaphore;

    public void check() throws InterruptedException {
        semaphore.acquire();
        semaphore.release();
    }

    public static void main(String[] args) throws IOException {
//        Runtime currentRuntime = Runtime.getRuntime();
//        Process process = currentRuntime.exec("ls -l");
//        if(process.isAlive()){
//            InputStream ir = null;
//            if(process.getErrorStream()!=null){
//                ir = process.getErrorStream();
//            }else if(process.getInputStream()!=null){
//                ir = process.getInputStream();
//            }
//            BufferedReader br = new BufferedReader(new InputStreamReader(ir));
//            String s = new String();
//            while((s=br.readLine())!=null){
//                out.println(s);
//            }
//            br.close();
//        }
//
//        out.println("STEP 1: Number of available logical processors..: "+currentRuntime.availableProcessors());
//        currentRuntime.addShutdownHook(new Thread(()-> out.println("Step 2: Shutdown Hook Called")));
//        new Thread(()->{out.println("STEP 3: Ending code ...");}).start();
//        new Thread(()->{out.println("STEP 4: Ending code ...");}).start();
        out.println("Flagval::"+Boolean.parseBoolean("#$%^&^E@$$%%"));
    }
}
