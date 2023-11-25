package ru.mirea.task20;

public class Matrix<T extends Number> {
    private T[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = (T[][]) new Number[rows][cols];
    }

    public void setElement(int i, int j, T value) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IllegalArgumentException("Invalid matrix indices");
        }
        data[i][j] = value;
    }

    public T getElement(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IllegalArgumentException("Invalid matrix indices");
        }
        return data[i][j];
    }

    public Matrix<T> add(Matrix<T> other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition");
        }

        Matrix<T> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, addElements(getElement(i, j), other.getElement(i, j)));
            }
        }

        return result;
    }

    public Matrix<T> subtract(Matrix<T> other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction");
        }

        Matrix<T> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, subtractElements(getElement(i, j), other.getElement(i, j)));
            }
        }

        return result;
    }

    public Matrix<T> multiplyByScalar(T scalar) {
        Matrix<T> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, multiplyElements(getElement(i, j), scalar));
            }
        }

        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must match the number of rows in the second matrix");
        }

        Matrix<T> result = new Matrix<>(rows, other.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                T sum = multiplyElements(getElement(i, 0), other.getElement(0, j));

                for (int k = 1; k < cols; k++) {
                    sum = addElements(sum, multiplyElements(getElement(i, k), other.getElement(k, j)));
                }

                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    private T addElements(T a, T b) {
        return (T) (Number) (a.doubleValue() + b.doubleValue());
    }

    private T subtractElements(T a, T b) {
        return (T) (Number) (a.doubleValue() - b.doubleValue());
    }

    private T multiplyElements(T a, T b) {
        return (T) (Number) (a.doubleValue() * b.doubleValue());
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix<Integer> matrix1 = new Matrix<>(2, 2);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(1, 0, 3);
        matrix1.setElement(1, 1, 4);

        Matrix<Integer> matrix2 = new Matrix<>(2, 2);
        matrix2.setElement(0, 0, 5);
        matrix2.setElement(0, 1, 6);
        matrix2.setElement(1, 0, 7);
        matrix2.setElement(1, 1, 8);

        System.out.println("Matrix 1:");
        matrix1.print();

        System.out.println("\nMatrix 2:");
        matrix2.print();

        System.out.println("\nMatrix 1 + Matrix 2:");
        Matrix<Integer> sumMatrix = matrix1.add(matrix2);
        sumMatrix.print();

        System.out.println("\nMatrix 1 - Matrix 2:");
        Matrix<Integer> diffMatrix = matrix1.subtract(matrix2);
        diffMatrix.print();

        System.out.println("\nMatrix 1 * 2:");
        Matrix<Integer> scaledMatrix = matrix1.multiplyByScalar(2);
        scaledMatrix.print();

        System.out.println("\nMatrix 1 * Matrix 2:");
        Matrix<Integer> productMatrix = matrix1.multiply(matrix2);
        productMatrix.print();
    }
}
