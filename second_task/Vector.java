public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarMultiply(Vector other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public Vector vectorMultiply(Vector other) {
        double newX = y * other.getZ() - z * other.getY();
        double newY = z * other.getX() - x * other.getZ();
        double newZ = x * other.getY() - y * other.getX();
        return new Vector(newX, newY, newZ);
    }

    public double cosBetweenVectors(Vector other) {
        double dot = scalarMultiply(other);
        double lenThis = length();
        double lenOther = other.length();
        return dot / (lenThis * lenOther);
    }

    public Vector add(Vector other) {
        return new Vector(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector subtract(Vector other) {
        return new Vector(x - other.getX(), y - other.getY(), z - other.getZ());
    }

    public static Vector[] generateRandomVectors(int N) {
        Vector[] vectors = new Vector[N];
        for (int i = 0; i < N; i++) {
            double x = (Math.random() * 200) - 100;
            double y = (Math.random() * 200) - 100;
            double z = (Math.random() * 200) - 100;
            vectors[i] = new Vector(x, y, z);
        }
        return vectors;
    }

    @Override
    public String toString() {
        return String.format("Vector(%.2f, %.2f, %.2f)", x, y, z);
    }
}

class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);

        System.out.println("Длина v1: " + v1.length());
        System.out.println("Скалярное произведение: " + v1.scalarMultiply(v2));
        System.out.println("Косинус угла: " + v1.cosBetweenVectors(v2));
        System.out.println("Векторное произведение: " + v1.vectorMultiply(v2));
        System.out.println("Сумма: " + v1.add(v2));
        System.out.println("Разность: " + v1.subtract(v2));

        Vector[] randomVectors = Vector.generateRandomVectors(5);
        for (Vector vec : randomVectors) {
            System.out.println(vec);
        }
    }
}
