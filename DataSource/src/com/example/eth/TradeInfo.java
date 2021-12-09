package com.example.eth;

public class TradeInfo implements Comparable<TradeInfo> {

    private final long id;
    private final long timestamp;
    private final double count;
    private final double volume;

    public TradeInfo(long id, long timestamp, double count, double volume) {
        this.id = id;
        this.timestamp = timestamp;
        this.count = count;
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getCount() {
        return count;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public int compareTo(TradeInfo obj) {
        if (this == obj) {
            return 0;
        }

        if (this.id > obj.id) {
            return 1;
        } else if (this.id < obj.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        return this.id == ((TradeInfo)obj).getId();
    }

    @Override
    public int hashCode() {
        return ((Long)this.id).hashCode() + 66;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + this.id + "\n");
        sb.append("Timestamp: " + this.timestamp + "\n");
        sb.append("Count: " + this.count + "\n");
        sb.append("Volume: " + this.volume + "\n\n");

        return sb.toString();
    }
}
