package com.interview.finra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Zhenxin Lei
 *
 * one zip can only contain unique person 
 *
 */



public class MainTest {
	
    public static void main(String []args){
        System.out.println("Hello World");
        
        Set<Person> pSet=new HashSet<Person>();
        /*List<Person> pList=new ArrayList<Person>();
        Map<String, Set<Person>> map=new HashMap<String, Set<Person>>();*/
        
        Person p= new Person("jason","12345");
        pSet.add(p);
        p= new Person("jason","12345");
        pSet.add(p);
        p= new Person("jason","12346");
        pSet.add(p);
        p= new Person("andy","12346");
        pSet.add(p);
       
        Iterator i =pSet.iterator();
        
        while (i.hasNext()){
        	Person element = (Person) i.next();
        	System.out.println("set element: "+element.getName()+"  "+element.getZipCode());
        	/*System.out.println("set element: "+((Person )i.next()).getName()+"  "+((Person )i.next()).getZipCode());*/
        }
     }

}
