package com.littlemelon.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton(){}
	public static ThreadSafeSingleton getInstanceDoubleCheck(){
		if(instance==null){
			synchronized(ThreadSafeSingleton.class){
				if(instance==null){
					instance=new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}
