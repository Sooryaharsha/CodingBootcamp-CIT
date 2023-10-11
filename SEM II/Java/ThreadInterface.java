class ThreadTest1 implements Runnable{

    public void run(){
        try{
            for(int i=0; i<4;i++){
                System.out.println("The Number is " + i);
                Thread.sleep(1000);
        }}catch(Exception e){
            e.printStackTrace();
    }
}
}



public class ThreadInterface {

    public static void main(String[] args) {
 
        Runnable r = new ThreadTest1();
        Thread t = new Thread(r);
        t.start();
    }
    
}
