package Stackwithproducerconsumer;



public class StackConsumer implements Runnable {
	private MyStack myStack;
	
	
	public StackConsumer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}


	@Override
	public void run() {
		for(int i=0;i<26;i++)
		{
			try {
				System.out.println("Poped=>"+myStack.pop());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
