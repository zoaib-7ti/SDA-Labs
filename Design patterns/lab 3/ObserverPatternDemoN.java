import java.util.ArrayList;
import java.util.List;

class Subject {

   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer) { // Add observer (subscribe)
      observers.add(observer);
   }

   public void detach(Observer observer) { // Remove observer (unsubscribe)
      observers.remove(observer);
   }

   public void notifyAllObservers() {
      for (Observer observer : observers) {
         observer.update();
      }
   }
}

abstract class Observer {
   protected Subject subject;

   public abstract void update();
}

class BinaryObserver extends Observer {

   public BinaryObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
   }
}

class OctalObserver extends Observer {

   public OctalObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
   }
}

class HexaObserver extends Observer {

   public HexaObserver(Subject subject) {
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
   }
}

public class ObserverPatternDemoN {
   @SuppressWarnings("unused")
   public static void main(String[] args) {
      Subject youtubeChannel = new Subject(); // Creating a YouTube Channel

      // Subscribers joining the channel
      HexaObserver subscriber1 = new HexaObserver(youtubeChannel);
      OctalObserver subscriber2 = new OctalObserver(youtubeChannel);
      BinaryObserver subscriber3 = new BinaryObserver(youtubeChannel);

      // YouTube Channel uploads a new video (state = 15)
      System.out.println("First video uploaded: 15");
      youtubeChannel.setState(15);

      // One subscriber unsubscribes (OctalObserver)
      System.out.println("\nSubscriber 2 (Octal) Unsubscribed...");
      youtubeChannel.detach(subscriber2);

      // New video uploaded (state = 10)
      System.out.println("\nSecond video uploaded: 10");
      youtubeChannel.setState(10);
   }
}
