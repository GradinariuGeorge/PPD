package listThreads.nodeSync;

public class NodeSync<T> {

	T value;
	NodeSync<T> next;

	public NodeSync() {
	}

	public NodeSync(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public NodeSync<T> getNext() {
		return next;
	}

	public void setNext(NodeSync<T> next) {
		this.next = next;
	}

	public boolean hasNext() {
		return next != null;
	}
}
