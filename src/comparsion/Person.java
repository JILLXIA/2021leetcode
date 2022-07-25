package comparsion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable{
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object o){
		Person p = (Person)o;
		if(this.age==p.age){ // if 2 people have the same age, use lexicographically sorting
			return this.name.compareTo(p.name);
		}
		return this.age - p.age; // ascending order sort by age
	}

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Tom",21));
		list.add(new Person("Pat",17));
		list.add(new Person("Apple",21));
		list.add(new Person("Jill",22));
		list.add(new Person("Zoe",21));

		Collections.sort(list);
		List<Student> listStu = new ArrayList<>();
		listStu.add(new Student("Tom",21,2.1));
		listStu.add(new Student("Pat",17,1.7));
		listStu.add(new Student("Apple",21,2.1));
		listStu.add(new Student("Jill",22,2.2));
		listStu.add(new Student("Zoe",21,2.1));
		Collections.sort(listStu, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Double.compare(o1.time, o2.time);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(Student p:listStu){
			sb.append(p.stuName);
			sb.append("; ");
		}
		System.out.println(sb.toString());
	}
}


class Student{
	String stuName;
	int stuAge;
	double time;

	public Student(String stuName, int stuAge, double time) {
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.time = time;
	}
}