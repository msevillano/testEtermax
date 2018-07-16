public abstract class Position {
    private double x;
    private double y;

    public void setPosition(double x, double y) {this.x = x; this.y = y;}

    public Position () {
        x = 0;
        y = 0;
    }

    public double distance(Position p) {
        double deltaX = this.x - p.x, deltaY = this.y - p.y;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
