package com.pippala.st.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 数据库连接池
 */
public class DBPool {
    public static LinkedList<Connection> pool = new LinkedList<>();

    public DBPool(int initialSize) {
        for (int i=0;i<initialSize;i++){
            pool.addLast(SqlConnectionImpl.fetchConnection());
        }
    }


    //获取数据库连接
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool){
            if (mills<0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long overtime = System.currentTimeMillis()+mills;
                long remain = mills;
                while (pool.isEmpty()&&remain>0){
                    pool.wait(remain);
                    remain = overtime - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!pool.isEmpty()){
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }

    //放回连接池
    public void releaseConn(Connection connection){
        if (connection!=null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }
}
