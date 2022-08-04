package ss3_class_object.bai_tap.StopWatch;

public class StopWatch {
    private double startTime;
    private double endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double start() {
        return this.startTime = System.currentTimeMillis();
    }

    public double stop() {
        return this.endTime = System.currentTimeMillis();
    }

    public double getElapsedTime() {
        return (this.endTime - this.startTime);
    }
}
