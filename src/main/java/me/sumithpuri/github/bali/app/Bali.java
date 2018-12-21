package me.sumithpuri.github.bali.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.sumithpuri.github.bali.spring.orm.sample.Doctor;
import me.sumithpuri.github.bali.spring.orm.sample.HibernateDoctorDao;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Blog Post URL		http://www.techilashots.com/2009/01/spring-hibernate-ehcache-recipe.html
 * Blog Short URL		https://goo.gl/sKX2SV
 * Package Prefix 		me.sumithpuri.github.bali
 * Project Codename		bali
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class Bali {
	
	private static boolean isDatabaseSetup = false;
	
	public static void main(String args[]) {
		
		// SherlockEvent DataM1 = new SherlockEvent();
		System.out.println("Copyright (c) 2018-19,	Sumith Kumar Puri");
		System.out.println();
		System.out.println("Project Codename      Bali");
		System.out.println("Project Description   Spring, Hibernate, EhCache (Performance) Demo Code");
		System.out.println("Technical Blog        http://www.techilashots.com");
		System.out.println("Technical Blog Post   https://goo.gl/sKX2SV");
		System.out.println("[Developer Notes]     [01] Use Java Version 9.0+ Compiler");
		System.out.println();
		System.out.println("Spring, Hibernate, EhCache (2nd Level Cache) Demo n Performance");
		System.out.println("################################################################");
		
		if(isDatabaseSetup) {
	 		
			ApplicationContext context = new ClassPathXmlApplicationContext("orm-sample.xml");
			
			HibernateDoctorDao doctorDao = (HibernateDoctorDao) context.getBean("doctorDao");
			Doctor doctor = doctorDao.getDoctorById(2);
		
			System.out.println("PERFORMANCE COMPARISON (in seconds)");
			System.out.println("==================================");
			
			long startTime = System.currentTimeMillis();
			List<Doctor> doctors = doctorDao.getAllDoctorsOnSecondLevelCache();
			long finishTime = System.currentTimeMillis();
		
			System.out.println("QUERY FETCH TIME (INITIAL): " + (finishTime-startTime)/1000.0);
			
			startTime = System.currentTimeMillis();
			doctors = doctorDao.getAllDoctorsOnHibernateOnly();
			finishTime = System.currentTimeMillis();
			
			System.out.println("QUERY FETCH TIME (HIBERNATE CACHE): " + (finishTime-startTime)/1000.0);	

			startTime = System.currentTimeMillis();
			doctors = doctorDao.getAllDoctorsOnSecondLevelCache();
			finishTime = System.currentTimeMillis();
			
			System.out.println("QUERY FETCH TIME (2ND LEVEL CACHE): " + (finishTime-startTime)/1000.0);
		
		} else {
		
			System.out.println("000. You may choose to Import the Project in Eclipse / Other IDE");
			System.out.println("000. Make Sure that Dependencies & Resources are in ClassPath");
			System.out.println("01a. Install MySQL Community Server Version 5.7.0+ [Developer Default]");
			System.out.println("01b. Make Sure that Schema is Created using [doctor.sql]");
			System.out.println("000. You may use MySQL Workbench or Eclipse to execute [doctor.sql]");
			System.out.println("02a. Make Sure you add the Password in the [orm-sample.xml]");
			System.out.println("000. *Update the [isDatabaseSetup] attribute to [true] in [Bali]*");
			System.out.println("02b. Next, Run [BaliDataLoader] from Eclipse/Console (With Classpath Set)");
			System.out.println("003. [Bali] Spring-Hibernate-EhCache Demo should show the Performance Data");
			System.out.println();
		}
	}
}
