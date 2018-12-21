package me.sumithpuri.github.bali.data.loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
public class BaliDataLoader {

	private Connection connection = null;

	public BaliDataLoader() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {

			System.out.println("Exception while Loading mySQL JDBC Driver!");
		}
	}

	public void loadConnection(String userName, String passWord, String databaseName, String serverName,
			Integer portNumber) {

		String connectionUrl = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + databaseName;

		try {

			connection = DriverManager.getConnection(connectionUrl, userName, passWord);
		} catch (Exception e) {

			System.out.println("Exception while creating a JDBC Connection!");
		}
	}

	public static void main(String args[]) {

		BaliDataLoader dataLoader = new BaliDataLoader();
		dataLoader.loadConnection("root", "Collabera@2018", "data_explosion", "localhost", 3306);

		try {

			dataLoader.refreshDatabase();
			dataLoader.loadDoctorData();
		} catch (Exception e) {
			System.out.println("Error in executing SQL: " + e.getMessage());
		}
	}

	public void refreshDatabase() throws SQLException {

		Statement statement = connection.createStatement();
		statement.execute("DELETE FROM DOCTOR_TABLE");
		statement.close();
	}

	public void loadDoctorData() throws SQLException {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String select[] = new String[] { "SCURVY", "BERIBERI", "FOOTMOUTH", "CHOLERA", "TYPHOID", "FLU" };
		String insertStatement = "INSERT INTO DOCTOR_TABLE VALUES(?,?,?)";
		PreparedStatement statement = connection.prepareStatement(insertStatement);
		String doctorName = null;
		String speciality = null;

		for (int i = 1; i < 5000; i++) {

			int alphabetFr = (int) (Math.random() * alphabet.length());
			alphabetFr = (alphabetFr == 0) ? 1 : alphabetFr;
			int remAlphabet = alphabet.length() - alphabetFr;
			int alphabetTo = (int) (Math.random() * remAlphabet);
			int specialInd = (int) (Math.random() * select.length);
			doctorName = alphabet.substring(alphabetFr, alphabetFr + alphabetTo);
			speciality = select[specialInd];

			System.out.println("DOCTOR_TABLE: " + i + " " + doctorName + " " + speciality);

			statement.setInt(1, i);
			statement.setString(2, doctorName);
			statement.setString(3, speciality);

			statement.execute();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
