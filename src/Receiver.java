import java.util.concurrent.ThreadLocalRandom;

import javax.xml.crypto.Data;

    public class Receiver implements Runnable {
    private DataSend load;
 
    // standard constructors
 
    public void run() {
        for(String receivedMessage = load.receive();
          !"End".equals(receivedMessage);
          receivedMessage = load.receive()) {
            
            System.out.println(receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted"); 
            }
        }
    }

    public static void main(String[] args) {
        DataSend data = new DataSend();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));
        
        sender.start();
        receiver.start();
    }
}

