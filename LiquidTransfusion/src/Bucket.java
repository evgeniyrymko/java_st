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

    public boolean isEmpty() {
        if (this.currentVolume == 0) {
            return true;
        }
        return false;
    }

    public boolean isFilled() {
        if (this.currentVolume == this.capacity) {
            return true;
        }
        return false;
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
