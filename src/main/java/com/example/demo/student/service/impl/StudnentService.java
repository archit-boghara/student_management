package com.example.demo.student.service.impl;

import com.example.demo.student.bean.StudentBean;
import com.example.demo.student.dao.StudentDao;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudnentService implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Map<String, Object>> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public List<Map<String, Object>> getCityWiseStudent(String string) {
        return studentDao.getCityWiseStudent(string);
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToCity(){
        return studentDao.getCountOfStudentAccordingToCity();
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToStandard(){
        return studentDao.getCountOfStudentAccordingToStandard();
    }

    @Override
    public List<Map<String, Object>> getCountOfStudentAccordingToStandardAndCity(){
        return studentDao.getCountOfStudentAccordingToStandardAndCity();
    }

    @Override
    public List<Map<String, Object>> getListOfStudentThoseCity_nameStartsFromGivenAlphabet(String alphabet){
        return studentDao.getListOfStudentThoseCity_nameStartsFromGivenAlphabet(alphabet);
    }

    @Override
    public List<Map<String, Object>> getStudentListWhoseNameIsSame(){
        return studentDao.getStudentListWhoseNameIsSame();
    }

    @Override
    public List<Map<String, Object>> getListOfTotalFeesStandardWise(){
        return studentDao.getListOfTotalFeesStandardWise();
    }

    @Override
    public List<Map<String, Object>> getSumOfFeesCityWiseAndStandardWise(){
        return studentDao.getSumOfFeesCityWiseAndStandardWise();
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoDoesNotPaidAnyAmount(){
        return studentDao.getListOfStudentWhoDoesNotPaidAnyAmount();
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoPaidFullFees(){
        return studentDao.getListOfStudentWhoPaidFullFees();
    }


    @Override
    public List<Map<String, Object>> getFessPendingStudent(){
        return studentDao.getFessPendingStudent();
    }

    @Override
    public List<Map<String, Object>> getListOfStudentWhoPaidFeesInCurrentMonth(){
        return studentDao.getListOfStudentWhoPaidFeesInCurrentMonth();
    }

    @Override
    public List<Map<String, Object>> getDateWiseStandardWiseFeesCollection(){
        return studentDao.getDateWiseStandardWiseFeesCollection();
    }

    @Override
    public List<Map<String, Object>> getCityWiseStandardWisePendingList(){
        return studentDao.getCityWiseStandardWisePendingList();
    }

    @Override
    public List<Map<String, Object>> getCountNumberOfStudentWhoAreInPendingList(){
        return studentDao.getCountNumberOfStudentWhoAreInPendingList();
    }

    @Override
    public int getStudentCount() {
        return studentDao.getStudentCount();
    }

    @Override
    public int insertTokenFeesProcedureCalling() {
        return studentDao.insertTokenFeesProcedureCalling();
    }

    @Override
    public int updatingFeesWithUpdatingStudentmasterDetails(StudentBean studentBean){ return studentDao.updatingFeesWithUpdatingStudentmasterDetails(studentBean); }

    @Override
    public Map getStudentyById(int id){
        return studentDao.getStudentyById(id);
    }

    @Override
    public int insertStudentBean(StudentBean studentBean){
        return studentDao.insertStudentBean(studentBean);
    }

    @Override
    public int updateStudent(StudentBean studentBean){
        return studentDao.updateStudent(studentBean);
    }

    @Override
    public int deleteStudent(StudentBean studentBean){
        return studentDao.deleteStudent(studentBean);
    }

}
