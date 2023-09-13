package com.STS.DAO;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.STS.Entity.Customer;


@Repository
@Transactional
public class CustomerDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	
	
	
	public Integer saveUser(Customer customer)
	{
		try
		{
		hibernateTemplate.save(customer);
		return 1;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	
	public Customer getByName(String username) {
		Customer userEntity = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
			criteria.add(Restrictions.eq("gmail", username));

			userEntity = (Customer) criteria.uniqueResult();
			
		} catch (Exception e) {
			
		}

		return userEntity;

	}


	public Customer getByID(Integer custumerId) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Customer.class);
		
		criteria.add(Restrictions.eq("id", custumerId));
		return (Customer) criteria.uniqueResult();
		
		
	}
}
