package com.example.demo.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.ProductInfo;
import com.example.demo.model.UserInfo;

//Transactional for Hibernate
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public User findEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
	    Criteria crit = session.createCriteria(User.class);
	    crit.add(Restrictions.eq("email", email));
	    return (User) crit.uniqueResult();
	}
	 
	@Override
	public PaginationResult<UserInfo> queryUsers(int page,
            int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + UserInfo.class.getName() //
                + "(p.id,p.email, p.password, p.userRole) " + " from "//
                + User.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.email) like :likeName ";
        }
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<UserInfo>(query, page, maxResult, maxNavigationPage);
    
	}
	 
	@Override
    public PaginationResult<UserInfo> queryUsers(int page, int maxResult,
            int maxNavigationPage) {
		return queryUsers(page, maxResult, maxNavigationPage, null);
	}
}
