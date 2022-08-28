class avgObject {
    double total;
    int c;

    public avgObject(int c, double time) {
        this.c = c;
        this.total = time;
    }

    void updateAvg(double newavg) {
        this.total += newavg;         // продолжительность поездки
        this.c += 1;                     // кол поездок
    }
}