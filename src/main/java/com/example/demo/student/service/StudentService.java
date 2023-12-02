package com.example.demo.student.service;

import com.example.demo.student.bean.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Map<String, Object>> getAllStudent();

    public List<Map<String, Object>> getCityWiseStudent(String string);

    public List<Map<String, Object>> getCountOfStudentAccordingToCity();

    public List<Map<String, Object>> getCountOfStudentAccordingToStandard();

    public List<Map<String, Object>> getCountOfStudentAccordingToStandardAndCity();

    public List<Map<String, Object>> getListOfStudentThoseCity_nameStartsFromGivenAlphabet(String alphabet);

    public List<Map<String, Object>> getStudentListWhoseNameIsSame();

    public List<Map<String, Object>> getListOfTotalFeesStandardWise();

    public List<Map<String, Object>> getSumOfFeesCityWiseAndStandardWise();

    public List<Map<String, Object>> getListOfStudentWhoDoesNotPaidAnyAmount();

    public List<Map<String, Object>> getFessPendingStudent();

    public List<Map<String, Object>> getListOfStudentWhoPaidFeesInCurrentMonth();

    public List<Map<String, Object>> getDateWiseStandardWiseFeesCollection();

    public List<Map<String, Object>> getCityWiseStandardWisePendingList();

    public List<Map<String, Object>> getCountNumberOfStudentWhoAreInPendingList();

    public int getStudentCount();

    public Map getStudentyById(int id);

    public int insertStudentBean(StudentBean studentBean);

    public int insertTokenFeesProcedureCalling();

    public int updatingFeesWithUpdatingStudentmasterDetails(StudentBean studentBean);


    public int deleteStudent(StudentBean studentBean);

    public int updateStudent(StudentBean studentBean);

    List<Map<String, Object>> getListOfStudentWhoPaidFullFees();
}
