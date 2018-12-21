package me.sumithpuri.github.bali.spring.orm.sample;

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
public class Doctor {

	private int doctor_id;
	private String doctor_name;
	private String doctor_speciality;
	
	public Doctor() {
		
	}
	
	public Doctor(int doctor_id, String doctor_name, String doctor_speciality) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_speciality = doctor_speciality;
	}

	public int getDoctor_id() {
		return doctor_id;
	}
	
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}
	
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	
	public String getDoctor_speciality() {
		return doctor_speciality;
	}
	
	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}
}
