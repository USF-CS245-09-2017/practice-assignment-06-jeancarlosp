
public class BinaryHeap {

	private int[] data;
	private int size ;

	public BinaryHeap() {
		data = new int[10];	
		size = 0;
	}



	public int parent(int child) {
		return (child-1)/2;
	}

	public int leftchild(int parent){
		return parent*2+1;
	}
	
	public int rightchild(int parent){
		return parent*2+2;

	}
	
	public void swap(int position1, int position2){
		int current = size;
		current = data[position1];
		data[position1] = data[position2];
		data[position2] = current;
	}


	public void add(int insert) {
		if (size == data.length)
			grow_queue();
		int current = size; 
		data[size++] = insert;
		while (data[current] < data[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	private void grow_queue(){
		int[] new_arr = new int[data.length*2]; 
		System.arraycopy(data,0,new_arr,0,data.length);
		data = new_arr;
	}

	public int remove(){
		int priority = data[0];
		swap(0,--size);
		if(size != 0)
			siftdown(0);
		return priority;
	}
	
	private void siftdown(int position){

		if (leftchild(position) >= size)
			return;

		int child = leftchild(position);

		if (rightchild(position) < size && data[rightchild(position)] < data[child])
			child = rightchild(position);

		if (data[child] < data[position]){
			swap(position, child);
			siftdown(child);

		}


	}

}
