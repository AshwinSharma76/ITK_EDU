import java.util.concurrent.RecursiveTask;

class FactorialTask extends RecursiveTask<Long> {

    private int start;
    private int end;

    public FactorialTask(int n) {
        this.start = 1;
        this.end = n;
    }

    public FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

   
    protected Long compute() {

        if (end - start <= 2) {
            long result = 1;
            for (int i = start; i <= end; i++) {
                result *= i;
            }
            return result;
        }

        int mid = (start + end) / 2;

        FactorialTask leftTask = new FactorialTask(start, mid);
        FactorialTask rightTask = new FactorialTask(mid + 1, end);

        leftTask.fork();

        long rightResult = rightTask.compute();

        long leftResult = leftTask.join();

        return leftResult * rightResult;
    }
}




public class ForkJoinPoolExample {
    public static void main(String[] args) {

        int n = 10;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Factorial " + n + "! = " + result);
    }
}
