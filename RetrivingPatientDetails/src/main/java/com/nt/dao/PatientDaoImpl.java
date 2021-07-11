package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.entity.Patient;
@Component("dao")
public class PatientDaoImpl implements IPatientDao {
	private static final String Select="select count(*) as count from corona_registration where pname=? and pmobile=?";
	private static final String Insert_Query="Insert into corona_registration (pname , paddr ,page , pmobile) values (?,?,?,?)";
	private static final String RetrivePatientList="select regNo , pname,paddr, page,pmobile from corona_registration ";
	
	@Autowired
	private DataSource ds;
	@Override
	public int login(Patient patient) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int count=0;
		try {
			System.out.println(ds+"============");
			if(ds!=null)
				con=ds.getConnection();
			if(con!=null) {
				pst=con.prepareStatement(Select);
				pst.setString(1, patient.getPname());
				pst.setString(2, patient.getMobile());
				rs=pst.executeQuery();
			}//if
			if(rs!=null)
				if(rs.next())
					count= rs.getInt(1);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int patientRegistration(Patient patient) {
		Connection con=null;
		PreparedStatement pst=null;
		int count=0;
		try {
			if(ds!=null)
				con=ds.getConnection();
			if(con!=null) {
				pst=con.prepareStatement(Insert_Query);
				pst.setString(1, patient.getPname());
				pst.setString(2, patient.getPaddr());
				pst.setString(3, patient.getPage());
				pst.setString(4, patient.getMobile());
				count=pst.executeUpdate();
			}//if
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Patient> fetchPatient() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Patient> listpatient=new ArrayList<Patient>();
		Patient patient=null;
		try {
			if(ds!=null)
				con=ds.getConnection();
			if(con!=null) {
				pst=con.prepareStatement(RetrivePatientList);
				rs=pst.executeQuery();
			}//if
			if(rs!=null)
				while (rs.next()) {
					//create patient object
					patient=new Patient();
					//set value to patient object
					patient.setRegNo(rs.getInt(1));
					patient.setPname(rs.getString(2));
					patient.setPage(rs.getString(4));
					patient.setPaddr(rs.getString(3));
					patient.setMobile(rs.getString(5));
					listpatient.add(patient);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listpatient;
	}

}
