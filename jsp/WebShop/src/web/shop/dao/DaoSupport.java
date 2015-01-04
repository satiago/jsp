/**
 * 
 */
package web.shop.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import web.shop.model.PageModel;
import web.shop.util.GenericsUtils;

/**
 * @author yangsatiago
 *
 */
@Transactional
@SuppressWarnings("unchecked")
public class DaoSupport<T> implements BaseDao<T> {
	// 泛型的类型
	protected Class<T> entityClass = GenericsUtils.getGenericType(this.getClass());
	// Hibernate模板
	@Autowired
	protected HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		getTemplate().save(obj);
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Object obj) {
		// TODO Auto-generated method stub
		getTemplate().saveOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		getTemplate().update(obj);
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable... ids) {
		// TODO Auto-generated method stub
		for(Serializable id : ids)
		{
			T t = (T) getTemplate().load(this.entityClass, id);
			getTemplate().delete(t);
		}
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#get(java.io.Serializable)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public T get(Serializable entityId) {
		// TODO Auto-generated method stub
		return (T) getTemplate().get(this.entityClass, entityId);
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#load(java.io.Serializable)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public T load(Serializable entityId) {
		// TODO Auto-generated method stub
		return (T) getTemplate().load(this.entityClass, entityId);
	}

	/* (non-Javadoc)
	 * @see web.shop.dao.BaseDao#uniqueResult(java.lang.String, java.lang.Object[])
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Object uniqueResult(final String hql, final Object[] queryParams) {
		// TODO Auto-generated method stub
		return getTemplate().execute(new HibernateCallback()
		{

			/* (non-Javadoc)
			 * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
			 */
			@Override
			public Object doInHibernate(Session arg0)
					throws HibernateException {
				// TODO Auto-generated method stub
				Query query = arg0.createQuery(hql);
				setQueryParams(query, queryParams);
				return query.uniqueResult();
			}
			
		}
		);
	}
	
	/**
	 * 对query中的参数赋值
	 * @param query
	 * @param queryParams
	 */
	protected void setQueryParams(Query query, Object[] queryParams){
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i, queryParams[i]);
			}
		}
	}
	
	/**
	 * 获取Session对象
	 * @return
	 */
//	protected Session getSession(){
//		return (!this.template.isAllowCreate() ?
//		    SessionFactoryUtils.getSession(this.template.getSessionFactory(), false) :
//				SessionFactoryUtils.getSession(
//						this.template.getSessionFactory(),
//						this.template.getEntityInterceptor(),
//						this.template.getJdbcExceptionTranslator()));
//	}
	/**
	 * 获取指定对象的信息条数
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public long getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from " + GenericsUtils.getGenericName(this.entityClass);
		return (Long)uniqueResult(hql,null);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(int pageNo, int maxResult) {
		// TODO Auto-generated method stub
		return find(null, null, null, pageNo, maxResult);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(int pageNo, int maxResult, String where,
			Object[] queryParams) {
		// TODO Auto-generated method stub
		return find(where, queryParams, null, pageNo, maxResult);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(int pageNo, int maxResult,
			Map<String, String> orderby) {
		// TODO Auto-generated method stub
		return find(null, null, orderby, pageNo, maxResult);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public PageModel<T> find(final String where, final Object[] queryParams,
			final Map<String, String> orderby, final int pageNo, final int maxResult) {
		// TODO Auto-generated method stub
		final PageModel<T> pageModel = new PageModel<T>();//实例化分页对象
		pageModel.setPageNo(pageNo);//设置当前页数
		pageModel.setPageSize(maxResult);//设置每页显示记录数
		getTemplate().execute(new HibernateCallback() {//执行内部方法
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = new StringBuffer().append("from ")//添加form字段
								.append(GenericsUtils.getGenericName(entityClass))//添加对象类型
								.append(" ")//添加空格
								.append(where == null ? "" : where)//如果where为null就添加空格,反之添加where
								.append(createOrderBy(orderby))//添加排序条件参数
								.toString();//转化为字符串
				Query query = session.createQuery(hql);//执行查询
				setQueryParams(query,queryParams);//为参数赋值
				List<T> list = null;//定义List对象
				// 如果maxResult<0，则查询所有
				if(maxResult < 0 && pageNo < 0){
					list = query.list();//将查询结果转化为List对象
				}else{
					list = query.setFirstResult(getFirstResult(pageNo, maxResult))//设置分页起始位置
								.setMaxResults(maxResult)//设置每页显示的记录数
								.list();//将查询结果转化为List对象
					//定义查询总记录数的hql语句
					hql = new StringBuffer().append("select count(*) from ")//添加hql语句
									.append(GenericsUtils.getGenericName(entityClass))//添加对象类型
									.append(" ")//添加空格
									.append(where == null ? "" : where)//如果where为null就添加空格,反之添加where
									.toString();//转化为字符串
					query = session.createQuery(hql);//执行查询
					setQueryParams(query,queryParams);//设置hql参数
					int totalRecords = ((Long) query.uniqueResult()).intValue();//类型转换
					pageModel.setTotalRecords(totalRecords);//设置总记录数
				}
				pageModel.setList(list);//将查询的list对象放入实体对象中
				return null;
			}
		});
		return pageModel;//返回分页的实体对象
	}
	
	/**
	 * 获取分页查询中结果集的起始位置
	 * @param pageNo 第几页
	 * @param maxResult 页面显示的记录数
	 * @return 起始位置
	 */
	protected int getFirstResult(int pageNo,int maxResult){
		int firstResult = (pageNo-1) * maxResult;
		return firstResult < 0 ? 0 : firstResult;
	}
	/**
	 * 创建排序hql语句
	 * @param orderby
	 * @return 排序字符串
	 */
	protected String createOrderBy(Map<String, String> orderby){
		StringBuffer sb = new StringBuffer("");
		if(orderby != null && orderby.size() > 0){
			sb.append(" order by ");
			for(String key : orderby.keySet()){
				sb.append(key).append(" ").append(orderby.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

}
