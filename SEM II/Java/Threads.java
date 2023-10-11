import java.util.*;

class ThreadTest extends Thread{

    public void run(){
        for(int i=0;i<3;i++){
            try{
            System.out.println("the No is : " + i);
            sleep(1000);

            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
}

public class Threads {

    public static void main(String[] args) {
        
        ThreadTest t = new ThreadTest();
        
        t.start();
        System.out.println("Boolean : "+t.isAlive());

        try {
            t.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ThreadTest t1 = new ThreadTest();
        
        t1.start();
        t1.setPriority(3);
        System.out.println("Thread Priority: " + t1.getPriority());
    } 
}
