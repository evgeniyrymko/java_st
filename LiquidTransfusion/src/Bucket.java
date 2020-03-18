public class Bucket {
    private int capacity;
    private int currentVolume;

    public Bucket(int capacity) {
        this.capacity = capacity;
        this.currentVolume = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void transfuse(Bucket bucket, int volume) {
        this.currentVolume -= volume;
        bucket.currentVolume += volume;
    }

    public void makeFilled() {
        this.currentVolume = this.capacity;
    }

    public void makeEmpty() {
        this.currentVolume = 0;
    }
}
