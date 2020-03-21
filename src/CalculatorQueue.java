<<<<<<< HEAD

class CalculatorQueue 
{
	private int arr[]; // penyimpan elemen
	private int front; // indeks head
	private int end; // indeks tail
	private int cap;
	private int count; // current size
	
    public CalculatorQueue(int size)
	{
		arr = new int[size];
		cap = size;
		front = 0;
		end = -1;
		count = 0;
	}

	public Boolean isEmpty()
	{
		return (count == 0);
	}

	public Boolean isFull()
	{
		return (count == cap);
	}


    // MC
	public void popQueue()
	{
		if (isEmpty())
		{
			System.out.println("QUEUE IS EMPTY");
		}

		//System.out.println(arr[front]);

		front = (front + 1) % cap;
		count--;
	}

    // MR
	public void pushQueue(int x)
	{
		if (isFull())
		{
			System.out.println("QUEUE IS FULL");
		}

		end = (end + 1) % cap;
		arr[end] = x;
		count++;
	}

	public int peek()
	{
		if (isEmpty()) 
		{
			System.out.println("QUEUE IS EMPTY");
		}
		return arr[front];
	}
	
    // tester
	public static void main (String[] args)
	{
		CalculatorQueue q = new CalculatorQueue(5);

		q.pushQueue(1);
		q.pushQueue(2);
		q.pushQueue(3);
        q.pushQueue(4);
		
		System.out.println("Front element is: " + q.peek());
		q.popQueue();
		System.out.println("Front element is: " + q.peek());
		q.popQueue();
        System.out.println("Front element is: " + q.peek());
		q.popQueue();
		
		if (q.isEmpty()) System.out.println("Queue Is Empty");
		else System.out.println("Queue Is Not Empty");
	}