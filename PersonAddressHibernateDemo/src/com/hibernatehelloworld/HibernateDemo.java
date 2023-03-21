package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Address;
import com.hibernatehelloworld.domain.Person;
import com.hibernatehelloworld.utils.HibernateUtil;

public class HibernateDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address address1 = new Address("1234 Home Street","Mumbai","577101");
		Address address2 = new Address("1234 Work Street","Mumbai","577102");
		
		Person person = new Person("Max",address1,address2);
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}
}
