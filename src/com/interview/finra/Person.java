package com.interview.finra;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {
	private String name;
	private String zipCode;
	
	public Person(String name, String zipCode) {
		super();
		this.name = name.toUpperCase();
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * override equals() is to make sure to check if content of person is same, then 
	 * two person is a same one. 
	 * 
	 * override hashcode is to make sure if person1.equals(person2) is true, then hashcode 
	 * is same. 
	 */
	@Override
	public boolean equals(Object p){
		if (p == null) return false;
	    if (p == this) return true;
	   // if (!(p instanceof Person))return false;
		if(p instanceof Person ){
			if (this.name.compareToIgnoreCase(((Person) p).getName())==0){
				if (this.zipCode.compareToIgnoreCase(((Person) p).getZipCode())==0){
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public int hashCode(){
		//int hashCode=super.hashCode(); doesnot work
		int prime=31;
		int hashCode=1;
		hashCode=prime*1+this.name.hashCode()+this.zipCode.hashCode();
		return hashCode;
	}
	
	//TEST
	public static void main(String []args){
        System.out.println("Hello World");
        
        Set<Person> pSet=new HashSet<Person>();
        /*List<Person> pList=new ArrayList<Person>();
        Map<String, Set<Person>> map=new HashMap<String, Set<Person>>();*/
        
        Person p= new Person("jason","12345");
        pSet.add(p);
        p= new Person("Jason","12345");
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
