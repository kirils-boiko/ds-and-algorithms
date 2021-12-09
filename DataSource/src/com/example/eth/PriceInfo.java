package com.example.eth;

public class PriceInfo implements Comparable<PriceInfo> {

    private final long id;
    private final long timestamp;
    private final double open;
    private final double close;
    private final double high;
    private final double low;

    public PriceInfo(long id, long timestamp, double open, double close, double high, double low) {
        this.id = id;
        this.timestamp = timestamp;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public long getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    @Override
    public int compareTo(PriceInfo obj) {
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

        return this.id == ((PriceInfo)obj).getId();
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
        sb.append("Open: " + this.open + "\n");
        sb.append("Close: " + this.close + "\n");
        sb.append("High: " + this.high + "\n");
        sb.append("Low: " + this.low + "\n\n");

        return sb.toString();
    }
}
