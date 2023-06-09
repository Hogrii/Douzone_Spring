package springbook.user.main;

import java.sql.SQLException;

import springbook.user.dao.DUserDao;
import springbook.user.dao.NUserDao;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
		//怨듯넻 肄붾뱶
		//UserDao dao = new UserDao();
		//媛� 踰ㅻ뜑 留덈떎 援ы쁽�릺�뒗 �겢�옒�뒪瑜� �떖由� �븯�뿬�빞 �븳�떎
		
		//N사
		//NUserDao dao = new NUserDao();
		
		//D사
		//DUserDao dao = new DUserDao();
		
		UserDao dao = new NUserDao();
		//遺�紐⑦��엯 (�떎�삎�꽦)
		
		User user = new User();
		user.setId("kglim");
		user.setName("�솉湲몃룞");
		user.setPassword("1004");

		// insert
		dao.add(user);

		System.out.println(user.getId() + "�벑濡앹꽦怨�");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user.getId() + "議고쉶�꽦怨�");

	}

}
/*
create table users
(
  id varchar2(20) primary key,
  name varchar2(20) not null,
  password varchar2(20) not null
);

*/