package listThreads.nodeSync;

public class Iterator {
    NodeSync<Double> nodeSync;

    public Iterator(NodeSync<Double> nodeSync) {
        this.nodeSync = nodeSync;
    }

    public synchronized boolean isValid() {
        return this.nodeSync != null;
    }

    public void next() {
        this.nodeSync = this.nodeSync.getNext();
    }

    public synchronized double getValue() {
        return this.nodeSync.getValue();
    }
}
