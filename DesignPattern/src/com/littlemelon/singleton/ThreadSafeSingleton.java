package com.littlemelon.singleton;

public class ThreadSafeSingleton {
	private ThreadSafeSingleton instance;
	private ThreadSafeSingleton(){}
	public ThreadSafeSingleton getInstanceDoubleCheck(){
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
