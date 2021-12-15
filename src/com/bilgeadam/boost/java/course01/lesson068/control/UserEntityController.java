package com.bilgeadam.boost.java.course01.lesson068.control;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.boost.java.course01.lesson068.entity.UserEntity;

public class UserEntityController implements Controllable<UserEntity> {
	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdýr" + Controllable.class);
		} catch (Exception e) {
			System.out.println("ekleme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(UserEntity entity) {
		
		try {
			UserEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Baþarýlý " + UserEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(UserEntity entity) {
		try {
			UserEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Baþarýlý " + UserEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<UserEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from UserEntity as str where str.id>=:key";
			TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<UserEntity> arrayList = (ArrayList<UserEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + UserEntity.class);
			return arrayList;
		} else {
			String hql = "select str from UserEntity as str where str.id>=:key";
			TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<UserEntity> arrayList = (ArrayList<UserEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + UserEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public UserEntity find(long id) {
		Session session = databaseConnectionHibernate();
		UserEntity entity;
		try {
			entity = session.find(UserEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Aradýðýnýz kriterde sonuçlar bulunamadý ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find anýnda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UserEntity singleResult(long id) {
		return Controllable.super.singleResult(id);
	}
	
}
