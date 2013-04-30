package com.littlemelon.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		ThreadSafeSingleton instance1=ThreadSafeSingleton.getInstanceDoubleCheck();
		ThreadSafeSingleton instance2=ThreadSafeSingleton.getInstanceDoubleCheck();
		Util.p1("instance1==instance2?"+(instance1==instance2));
		ThreadSafeSingleton instance3=null;
		try{
			Constructor[] constructors=ThreadSafeSingleton.class.getDeclaredConstructors();
			for(Constructor constructor:constructors){
				constructor.setAccessible(true);
				instance3=(ThreadSafeSingleton)constructor.newInstance();
				break;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		Util.p1("instance1==instance3?"+(instance1==instance3));
		Util.p1("instance1.hashCode()="+instance1.hashCode());
		Util.p1("instance3.hashCode()="+instance3.hashCode());
	}
}
