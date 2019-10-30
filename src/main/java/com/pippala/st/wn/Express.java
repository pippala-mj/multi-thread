package com.pippala.st.wn;

public class Express {
    public final static String CITY = "深圳";

    private int km;
    private String site;

    public Express() {
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm(){
        this.km = 101;
        notifyAll();
    }

    public synchronized void changeSite(){
        this.site = "广州";
        notifyAll();
    }

    public synchronized void waitKm(){
        while (this.km<=100){
            try {
                wait();
                System.out.println("check km thread is " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km);
    }

    public synchronized void waitSite(){
        while (CITY.equals(this.site)){
            try {
                wait();
                System.out.println("check site thread is " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.site);
    }
}
