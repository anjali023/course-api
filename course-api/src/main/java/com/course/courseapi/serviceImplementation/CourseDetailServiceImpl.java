package com.course.courseapi.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.CourseDetailDAO;
import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.exception.CourseException;
import com.course.courseapi.service.CourseDetailService;

@Service //By default Singleton
//@Scope("prototype")
public class CourseDetailServiceImpl implements CourseDetailService{
	
	@Autowired
	private CourseDetailDAO courseDetailDAO;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Course> getAllCources() {
		// TODO Auto-generated method stub
		return courseDetailDAO.getAllCourse();
	}

	@Override
	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		List<Course> cousreNamelist = courseDetailDAO.getCourseName(c.getCourseName());
		if(cousreNamelist.isEmpty()) {
			courseDetailDAO.save(c);
		}
		
	}


	@Override
	public List<Course> getCourseById(int id) {
		// TODO Auto-generated method stub
		List<Course> courselist = courseDetailDAO.getCourseById(id);
		return  courselist;
	}

	@Override
	public Course updateCourse(int courseId, String courseName) {
		// TODO Auto-generated method stub
		List<Course> course = courseDetailDAO.getCourseById(courseId);
		course.get(0).setCourseName(courseName);
		courseDetailDAO.save(course.get(0));
		return null;
	}

	@Override
	public Course addSubjectToCourseById(int id, Subject subject) {
		// TODO Auto-generated method stub
		List<Course> courses = courseDetailDAO.getCourseById(id);
		if(Objects.nonNull(courses.get(0).getSubject())) {
			
			courses.get(0).getSubject().add(subject);
			
			courseDetailDAO.save(courses.get(0));
			
		}else {
			List<Subject> subjects = new ArrayList<>();
			subjects.add(subject);
			courses.get(0).setSubject(subjects);
			courseDetailDAO.save(courses.get(0));
		}
		
		return courses.get(0);
	}
	

	@Override
	public List<Course> getCourseByName(String name) {
		List<Course> coursenamelist = courseDetailDAO.getCourseName(name);
		return coursenamelist;
	}

	@Override
	public int test() throws CourseException {try {
		{
			// TODO Auto-generated method stub
			
			throw new CourseException("1001", "test exception", "test exception", "FAILED");
			
		}
	} catch (CourseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
	}
	
}
