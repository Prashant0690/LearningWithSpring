package org.pt.learn.hibernate.daoJpaImpl;

import javax.transaction.Transactional;

import org.pt.learn.hibernate.dao.IUserDao;
import org.pt.learn.hibernate.entity.Users;
import org.pt.learn.hibernate.genericDao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository ("userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<Users, Long> implements IUserDao {

}
