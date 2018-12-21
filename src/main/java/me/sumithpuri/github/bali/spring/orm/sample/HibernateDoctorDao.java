package me.sumithpuri.github.bali.spring.orm.sample;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springmodules.cache.annotations.Cacheable;

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
public class HibernateDoctorDao {
	
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Doctor getDoctorById(int doctorId) {
		
		return (Doctor) hibernateTemplate.get(Doctor.class, doctorId);
	}
	
	@Cacheable(modelId="doctorCacheModel")
	public List<Doctor> getAllDoctorsOnSecondLevelCache() {
		
		List results = hibernateTemplate.find(" FROM me.sumithpuri.github.bali.spring.orm.sample.Doctor");
		return results;
	}
	
	public List<Doctor> getAllDoctorsOnHibernateOnly() {
		
		List results = hibernateTemplate.find(" FROM me.sumithpuri.github.bali.spring.orm.sample.Doctor");
		return results;
	}
	
	public void saveDoctor(Doctor doctor) {
		hibernateTemplate.save(doctor);
	}
}
