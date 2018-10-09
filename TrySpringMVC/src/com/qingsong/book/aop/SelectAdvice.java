package com.qingsong.book.aop;

import com.qingsong.book.model.BookModel;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

/**
 * 
 * 本类是一个关于查询操作的通知,本类中的每一个方法都是一个 '增强'代码,或者你也可以理解这些方法都是通知,通知就是增强,增强就是通知
 * 
 * 将这些'增强'代码加入到正常业务方法上的过程叫做'织入'
 * 
 * 增强的意思就是将原来代码进行一定的深化、扩展、补充,这些统称为叫'增强'
 * 
 * @author 孟飞
 *
 */
public class SelectAdvice {
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 在执行业务方法之前,可以进行校验等相关动作,本方法是一个 '增强'代码
	 * 
	 */
	public void checkSystem() {
		logger.info("Before:检查系统完成!");
	}

	/**
	 * 在执行业务方法之后,可以进行清理工作,例如删除缓存,清理过期日志,本方法是一个 '增强'代码
	 * 
	 */
	public void cleanSystem() {
		logger.info("After:清理工作完成!");
	}

	/**
	 * 可以统计业务方法的执行时间,本方法是一个 '增强'代码
	 * 
	 * @param pjp
	 * @return 业务方法执行的返回值
	 * @throws Throwable
	 * @see 透过屏幕,也能看到可爱的你对这段代码深深的疑惑 ,送给你一个微笑~^_^~,希望你可以笑对生活,坚持看下去!
	 * 
	 */
	public Object recordMethodTime(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Around:统计时间增强进入");
		long begin = System.currentTimeMillis();
		Object o = pjp.proceed();
		long end = System.currentTimeMillis();
		String s = String.format("业务方法:%s执行花费了%s毫秒", pjp.getTarget().getClass() + "." + pjp.getSignature().getName(),
				(end - begin));
		logger.info(s);
		logger.info("Around:统计时间增强结束");
		return o;
	}

	/**
	 * 统计本次查询的数据量,本方法是一个 '增强'代码
	 * 
	 * @param bindParam
	 *            绑定业务方法的返回值,也就是将select*这些方法的返回值作为这个'增强'方法的入参
	 *            备注:select*这些业务方法和这个'增强'代码,你是没有利用代码将他们耦合在一起的,你是利用Spring AOP这个框架
	 *            通过修改配置文件来将他们耦合在一起并且发生了关系,这个就是Spring的魅力,他的作用本质上讲就是让你可以仅仅修改文本配置文件
	 *            就让对象和对象之间发生了关系,这样就可以减少很多工作量
	 *            所以Spring的核心功能无论是IOC还是AOP都是利用文本文件就可以快捷并精准的控制对象和对象之间的关系
	 *            只不过这种关系可能是IOC配置的引用关系,让对象和对象互相引用
	 *            也有可能是AOP,面向切面编程,也就是可以在某个方法执行前或者执行后再执行某个方法,而这个方法就是增强
	 *            不要被大量的名词还有繁琐的配置文件给吓到,理解框架的本质之后再去修改代码就轻松多了
	 *            (我们的课上并没有讲注解方式,而是文本配置文件的方式,目前就这两种方式,如果有精力可以自行学习注解的方式)
	 * 
	 */
	public void countNumber(List<BookModel> bindParam) {
		if (CollectionUtils.isEmpty(bindParam)) {
			logger.info("AfterReturn:统计增强方法:本次未查询出数据!");
			return;
		}
		String string = String.format("AfterReturn:本次查询出%s条书籍记录", bindParam.size());
		logger.info(string);
	}

//	/**
//	 * 将查询出来的英语分数进行加密,本方法是一个 '增强'代码
//	 *
//	 * @param bindParam
//	 *            绑定业务方法的返回值,也就是将select*这些方法的返回值作为这个'增强'方法的入参
//	 */
//	public void encryptMessage(List<StudentModel> bindParam) {
//		if (CollectionUtils.isEmpty(bindParam)) {
//			logger.info("AfterReturn:加密增强方法:本次未查询出数据!");
//			return;
//		}
//		for (StudentModel studentModel : bindParam) {
//			if (null != studentModel.getEnglish()) {
//				studentModel.setEnglish(-1);
//			}
//		}
//		logger.info("AfterReturn:加密完成!");
//	}
}
