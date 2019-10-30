package com.pippala.st.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumFJ {

    public static class MyTask extends RecursiveTask<Integer>{
        private final static int THRESHOLD = 10000;
        private int[] src;
        private int fromIndex;
        private int toIndex;

        public MyTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if (toIndex-fromIndex<=THRESHOLD){
                int count = 0;
                for (int i = fromIndex;i<=toIndex;i++){
                    count = count + src[i];
                }
                return count;
            }else {
                int mid = (fromIndex+toIndex)/2;
                MyTask left = new MyTask(src,fromIndex,mid);
                MyTask right = new MyTask(src,mid+1,toIndex);
                invokeAll(left,right);
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) {
        int[] src = MakeArray.makeArray();
        MyTask myTask = new MyTask(src,0,src.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        System.out.println(pool.invoke(myTask));
        System.out.println(System.currentTimeMillis()-start + "ms");
    }
}
