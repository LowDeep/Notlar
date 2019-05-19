package imports;

public class LList<T> {
	private Node<T> head;
	private int size;

	public LList(){
		this.head = null;
		size = 0;
	}

	public LList(T elem) {
		this.head = new Node<T>(elem);
		size ++;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LList(T head, LList<T> tail) {
		this.head = new Node<T>(head, tail.getHead());
	}

	public void setHead(Node<T> newHead) {
		this.head = newHead;
	}
	
	public Node<T> getHead(){
		return this.head;
	}

	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void add(T elem) {
		if (this.head == null) {
			head = new Node<T>(elem);		
		} else {
			Node<T> p = head;
			while(p.hasNext()) {
				p = p.getNext();
			}
			p.setNext(new Node<T>(elem));
		}
		size ++;
	}

	// Add to the beginning of the list (push to the stack)
	public void push(T elem) {
		this.setHead(new Node<T>(elem, this.getHead()));
		this.incSize();
	}

	// Remove from the beginning of the list (top of the stack)
	public T pop() {
		T elem =this.getHead().getData();
		this.setHead(this.getHead().getNext());
		this.decSize();
		return elem;
	}

	public void add(int index, T elem) {
		if (index == 0) {
			this.head = new Node<T>(elem, this.head);
		} else {
			int i = 0;
			Node<T> p = this.head;
			while (i < index - 1 && p.hasNext()) {
				p = p.getNext();
				i++;
			}
			Node<T> after = new Node<T>(elem, p.getNext());
			p.setNext(after);
		}
		size ++;
	}

	public void remove(int index) {
		if (index < size) {
			if (index == 0) {
				head = head.getNext();
			} else {
				int i = 0;
				Node<T> p = head;
				while (i < index - 1) {
					i++;
					p = p.getNext();
				}
				Node<T> after = p.getNext().getNext(); // p.next exists because index < size
				p.setNext(after);
			}

			size --;
		}
	}

	public void removeRec(int index) {
		if (this.head != null) size --;
		this.head = removeNode(index, this.head);

	}

	private Node<T> removeNode(int index, Node<T> elements){
		if (elements == null) return null;
		else if (index == 0) return elements.getNext();
		else return new Node<T>(elements.getData(), removeNode(index-1, elements.getNext()));
	}

	// Add in the end (like enqueue for a queue structure)
	public void enqueue(T elem) {
		if (this.getHead() == null) this.setHead(new Node<T>(elem));
		else {
			Node<T> p = this.getHead();
			while (p.hasNext()) p = p.getNext();
			p.setNext(new Node<T>(elem));
		}
		this.incSize();
	}

	public void enqueueRec(T elem) {
		this.setHead(enqueue(elem, this.getHead()));
	}
	
	// Add in the end (like enqueue for a queue structure)
	private Node<T> enqueue(T elem, Node<T> L) {
		if (L == null) {
			size ++;
			return new Node<T>(elem);
		}
		else return new Node<T>(L.getData(), enqueue(elem, L.getNext()));
	}

	// remove from the end (like a queue) 
	public T dequeue() {
		if (this.getHead() == null) {
			return null;
		} else if (!this.getHead().hasNext()) {
			// single element to be removed
			T elem = this.getHead().getData();
			this.setHead(null);
			this.decSize();
			return elem;
		} else {
			// at least 2 elements in the list
			Node<T> p = this.getHead();
			Node<T> q = p.getNext();
			while (q.hasNext()) {
				p = q;
				q = q.getNext();
			}
			p.setNext(null);
			this.decSize();
			return q.getData();
		}
	}

	public int getSize() {
		return this.size;
	}
	
	public void incSize() {
		this.size ++;
	}
	
	public void decSize() {
		this.size --;
	}

	private int nbNodes(Node<T> node) {
		if (node == null) return 0;
		else return 1 + nbNodes(node.getNext());
	}

	public int sizeRec() {
		return this.nbNodes(head);
	}

	public int size() {
		if (head == null) return 0;
		else {
			int i = 1;
			Node<T> p = head;
			while (p.hasNext()) {
				p = p.getNext();
				i++;
			}
			return i;
		}
	}

	public String toStringNode() {
		if (head == null) return "()";
		else return this.nodeToString(head);
	}

	private String nodeToString(Node<T> p) {
		if (p.hasNext()) {
			return p.getData().toString() + ", " + nodeToString(p.getNext());
		} else {
			return p.getData().toString();
		}
	}

	public String toString() {
		String res = "";
		Node<T> p = head;
		while (p != null) {
			res += p.getData().toString();
			if (p.hasNext()) {
				res += ", ";
			}
			p = p.getNext();
		}
		return "(" + res + ")";
	}
	
	public boolean contains(T elem) {
		if (head == null) return false;
		else {
			Node<T> p = head;
			while (!p.getData().equals(elem) && p.hasNext()) {
				p = p.getNext();
			}
			return p.getData().equals(elem);
		}
	}
	
	public int indexOf(T elem) {
		if (head == null) return -1;
		else {
			Node<T> p = head;
			int i = 0;
			while (!p.getData().equals(elem) && p.hasNext()) {
				p = p.getNext();
				i++;
			}
			if (p.getData().equals(elem)) return i;
			else return -1;
		}
	}
	
	// Define a filter routine for LList<T>
	public LList<T> filter(Filter<T> f) {
		Node<T> p = this.getHead();
		Node<T> w = null;
		Node<T> res =  null;
		LList<T> Lres = new LList<T>();
		while (p != null && !f.filter(p.getData())) {
			p = p.getNext();
		}
		// if there is some elements left
		if (p != null) {
			res = new Node<T>(p.getData());
			w = res;
			while (p.hasNext()) {
				p = p.getNext();
				if (f.filter(p.getData())) {
					w.setNext(new Node<T>(p.getData()));
					w = w.getNext();
				}
			}
			Lres.setHead(res);
		}
		return Lres;
	}
	
	// Define a map routine for LList<T>
	public <K> LList<K> map(Mapper<T, K> m) {
		LList<K> Lres = new LList<K>();
		Node<T> p = this.getHead();
		if (p == null) return Lres;
		else {
			Node<K> res = new Node<K>(m.mapTo(p.getData()));
			Node<K> w = res;
			p = p.getNext();
			while (p != null) {
				w.setNext(new Node<K>(m.mapTo(p.getData())));
				w = w.getNext();
				p = p.getNext();
			}
			Lres.setHead(res);
			return Lres;
		}
	}
	
	// Define a reduce routine for LList<T>
	public <K> K reduceRec(Reducer<T, K> r) {
		 return reduceNode(r, this.getHead());
	}
	
	private <K> K reduceNode(Reducer<T, K> r, Node<T> L) {
		if (L == null) return r.getBase();
		else return r.reduce(L.getData(), reduceNode(r, L.getNext()));
	}
	
	public <K> K reduce(Reducer<T,K> r) {
		K res = r.getBase();
		if (this.getHead() == null) return res;
		// create a reverse order list
		Node<T> reverse = null;
		Node<T> p = this.getHead();
		while (p !=null) {
			reverse = new Node<T>(p.getData(), reverse);
			p = p.getNext();
		}
		while (reverse !=null) {
			res = r.reduce(reverse.getData(), res);
			reverse = reverse.getNext();
		}
		return res;
	}
}
