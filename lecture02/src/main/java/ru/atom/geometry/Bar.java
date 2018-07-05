package ru.atom.geometry;

public class Bar implements Collider {
    private Point min;
    private Point max;

    public Bar(Point first, Point second){

            int xmin, ymin, xmax, ymax;

            if (first.isMinX(second)) {
                xmin = first.getX();
            } else {
                xmin = second.getX();
            }

            if (first.isMinY(second)) {
                ymin = first.getY();
            } else {
                ymin = second.getY();
            }

            if (first.isMaxX(second)) {
                xmax = first.getX();
            } else {
                xmax = second.getX();
            }

            if (first.isMaxY(second)) {
                ymax = first.getY();
            } else {
                ymax = second.getY();
            }

            this.min = new Point(xmin, ymin);
            this.max = new Point(xmax, ymax);

    }

    public Bar(Point min, Point max, boolean isIntersect){
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isColliding(Collider other) {
        if(this.getClass().equals(other.getClass())){
            Bar bar = (Bar) other;
            Bar newBarIntersection = new Bar(
                    new Point(Math.max(bar.min.getX(), min.getX()), Math.max(min.getY(), bar.min.getY())),
                    new Point(Math.min(bar.max.getX(), max.getX()), Math.min(bar.max.getY(), max.getY())),
                    true
            );

            if((newBarIntersection.max.getX() >= newBarIntersection.min.getX()) && (newBarIntersection.max.getY() >= newBarIntersection.min.getY())){
                return true;
            }
            else{
                return false;
            }
        }
        else if(this.min.getClass().equals(other.getClass())){
            if(this.min.getX()<= ((Point)other).getX() && this.max.getX() >= ((Point)other).getX()){
                if(this.min.getY() <= ((Point)other).getY() && this.max.getY() >= ((Point)other).getY()){
                    return true;
                }
                return false;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Bar point = (Bar) o;

        if((point.min.equals(this.min) && point.max.equals(this.max))){
            return true;
        }
        else if((point.min.equals(this.max) && point.max.equals(this.min))) {
            return true;
        }
        else{
            return false;
        }
    }

}
