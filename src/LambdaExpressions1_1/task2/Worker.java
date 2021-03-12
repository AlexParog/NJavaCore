package LambdaExpressions1_1.task2;

public class Worker implements OnTaskDoneListener, OnTaskErrorListener {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }


    @Override
    public void onDone(String result) {
        System.out.println(result);
    }

    @Override
    public void onError(String result) {
        System.out.println(result);
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " not completed");
                break;
            } else callback.onDone("Task " + i + " is done");
        }
    }
}
