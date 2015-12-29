package com.crysisx;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;


public class IStudentDAOImpl implements IStudentDAO {

	private static SqlMapClient sqlMapClient = null;
	static {
		try {
			Reader reader = com.ibatis.common.resources.Resources.getResourceAsReader("com/crysisx/SqlMapConfig.xml");
			sqlMapClient = com.ibatis.sqlmap.client.SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
        try {
			sqlMapClient.insert("insertStudent",student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addStudentBySequence(Student student) {
		// TODO Auto-generated method stub
        
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
        try {
			System.out.println(sqlMapClient.delete("deleteStudentById",id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("updateStudent", student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> queryAllStudent() {
		// TODO Auto-generated method stub
		List<Student> studentList = null; 
        try
        {
        	studentList = sqlMapClient.queryForList("selectAllStudent");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return studentList;
	}

	@Override
	public List<Student> queryStudentByName(String name) {
		// TODO Auto-generated method stub
		List<Student> studentList = null; 
		try {
			studentList = sqlMapClient.queryForList("selectStudentByName", name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		return studentList;
	}

	@Override
	public Student queryStudentById(int id) {
		
		Student student =null;
		try {
			student =(Student) sqlMapClient.queryForObject("selectStudentById", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
											
		
		return student;
	}
	public static void main(String[] args) {
		
		IStudentDAO dao = new IStudentDAOImpl();
//		//1.queryAllStudent
//		for(Student student:dao.queryAllStudent()){
//			System.out.println(student);
//		}
		//2.queryStudentById
		
//		System.out.println(dao.queryStudentById(1));
		//3.addStudent
//		Student student = new Student();
//		student.setSid(4);
//		student.setBirth(Date.valueOf("2018-09-09"));
//		student.setSname("dasdsadd");
//		student.setMajor("game");
//		student.setScore(99);
//		dao.addStudent(student);
		//4.deleteStudentById
//		dao.deleteStudentById(1);
	    //5.updateStudent
//		Student student = new Student();
//		
//		student.setSid(4);
//		student.setBirth(Date.valueOf("2018-09-09"));
//		student.setSname("dasdsxxxxxxxxadd");
//		student.setMajor("game");
//		student.setScore(99);
//		dao.updateStudentById(student);
//6.queryStudentById
		
		for(Student student:dao.queryStudentByName("dasd")){
			System.out.println(student);
	}
	}
}
