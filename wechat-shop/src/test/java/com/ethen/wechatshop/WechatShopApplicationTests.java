package com.ethen.wechatshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatShopApplicationTests {

	@Autowired
	TransactionTemplate transactionTemplate;

	/**
	 * Description: spring 编程式事务
	 * 几个关键类及关键概念：
	 *
	 * 1.事务隔离级别
	 * 2.事务的传播
	 * 3.事务的提交回滚策略
	 *
	 * @see org.springframework.jdbc.datasource.DataSourceTransactionManager
	 * @see TransactionTemplate
	 * @see TransactionCallback
	 * @see TransactionStatus
	 * @see javax.sql.DataSource
	 */
	@Test
	public void contextLoads() {
		transactionTemplate.execute(new TransactionCallback<Object>() {

			/**
			 * Gets called by {@link TransactionTemplate#execute} within a transactional context.
			 * Does not need to care about transactions itself, although it can retrieve and
			 * influence the status of the current transaction via the given status object,
			 * e.g. setting rollback-only.
			 * <p>Allows for returning a result object created within the transaction, i.e. a
			 * domain object or a collection of domain objects. A RuntimeException thrown by the
			 * callback is treated as application exception that enforces a rollback. Any such
			 * exception will be propagated to the caller of the template, unless there is a
			 * problem rolling back, in which case a TransactionException will be thrown.
			 *
			 * @param status associated transaction status
			 * @return a result object, or {@code null}
			 * @see TransactionTemplate#execute
			 * @see CallbackPreferringPlatformTransactionManager#execute
			 */
			@Override
			public Object doInTransaction(TransactionStatus status) {

				return null;
			}
		});
	}

}
