package listThreads.listSync;

public class Iterator {
    Node<Double> node;

    public Iterator(Node<Double> node) {
        this.node = node;
    }

    public boolean isValid() {
        return this.node != null;
    }

    public void next() {
        this.node = this.node.getNext();
    }

    public double getValue() {
        return this.node.getValue();
    }
}
