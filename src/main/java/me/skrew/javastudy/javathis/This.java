package me.skrew.javastudy.javathis;

public class This {

    private int first;
    private int second;
    private int third;
    private long sum;

    public This() {}
    public This(int first) {
        this(first, 0);
    }

    public This(int first, int second) {
        this(first, second, 0);
    }

    public This(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.sum = first + second + third;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int first = 0;
        private int second = 0;
        private int third = 0;

        public Builder() {}

        public Builder first (int first) {
            this.first = first;
            return this;
        }

        public Builder second (int second) {
            this.second = second;
            return this;
        }

        public Builder third (int third) {
            this.third = third;
            return this;
        }

        public This build() {
            return new This(this);
        }
    }

    private This(Builder builder) {
        this.first = builder.first;
        this.second = builder.second;
        this.third = builder.third;
        this.sum = this.first + this.second + this.third;
    }

    public void printThis() {
        System.out.println(this);
    }

    public long getSum() {
        return this.sum;
    }
}
