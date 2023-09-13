package com.STS.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.STS.DTO.Pagination;
import com.STS.Entity.StockManage;

@Repository
@Transactional
public class StockManagemnetDaoImp implements StockManagemnetDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public StockManage checkByPruductId(String pruduct_id) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(StockManage.class);

		createCriteria.add(Restrictions.eq("productId", pruduct_id));
		return (StockManage) createCriteria.uniqueResult();

	}

	@Override
	public Integer saveProduct(StockManage stockAdd) {
		Session currentSession = sessionFactory.getCurrentSession();
		Integer save = (Integer) currentSession.save(stockAdd);
//		currentSession.close();
		return save;
	}

	@Override
	public List<StockManage> getAllproduct() {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(StockManage.class);

		return createCriteria.list();

	}
	
	
	
	
	
	@Override
	public Pagination<List<StockManage>> getAllproduct(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub

		Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(StockManage.class);
		cr.setProjection(Projections.rowCount());
		Long totalElements = (Long) cr.uniqueResult();
		cr.setProjection(null);

		int totalPages = (int) Math.ceil((double) totalElements / pageSize);

		cr.setFirstResult((pageNumber - 1) * pageSize);
		cr.setMaxResults(pageSize);

		List<StockManage> list = cr.list();

		Pagination<List<StockManage>> response = new Pagination<>();
		response.setTotalPages(list.size());
		response.setTotalElements(totalElements);
		response.setTotalElements(pageSize);
		response.setData(list);

		return response;
	}
	

	@Override
	public StockManage getByproductByid(Integer productId) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StockManage.class);
		criteria.add(Restrictions.eqOrIsNull("id", productId));
		return (StockManage) criteria.uniqueResult();
	}

	@Override
	public Integer updateStore(StockManage byproductByid) {
		try {
			hibernateTemplate.update(byproductByid);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

}
