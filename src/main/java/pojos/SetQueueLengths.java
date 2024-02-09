package pojos;

public class SetQueueLengths {
    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public int getNormalQueue() {
        return normalQueue;
    }

    public void setNormalQueue(int normalQueue) {
        this.normalQueue = normalQueue;
    }

    public int getPriorityQueue() {
        return priorityQueue;
    }

    public void setPriorityQueue(int priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public int getOffpeakQueue() {
        return offpeakQueue;
    }

    public void setOffpeakQueue(int offpeakQueue) {
        this.offpeakQueue = offpeakQueue;
    }

    private String pk, sk;
    private int normalQueue, priorityQueue, offpeakQueue;
}
