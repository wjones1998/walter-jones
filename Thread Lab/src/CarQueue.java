import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
		Queue<Integer> carQueue;
		Random direction;
		
		public CarQueue() {
			carQueue= new ArrayDeque<Integer>();
			direction= new Random();
			
			carQueue.add(direction.nextInt(4));
			carQueue.add(direction.nextInt(4));
			carQueue.add(direction.nextInt(4));
			carQueue.add(direction.nextInt(4));
			carQueue.add(direction.nextInt(4));
		}
		
		public void addToQueue() {
			class QueueRunnable implements Runnable{

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while(true) {
							carQueue.add(direction.nextInt(4));
							Thread.sleep(200);
						}
					}
					catch(InterruptedException exception) {
						
					}
					finally {
						
					}
				}
			}
			Runnable r = new QueueRunnable();
			Thread t = new Thread(r);
			t.start();
			
			
		}

		public int deleteQueue() {
			return carQueue.remove();
		}

	}
