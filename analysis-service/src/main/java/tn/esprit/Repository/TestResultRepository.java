package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entity.TestResult;


public interface TestResultRepository extends JpaRepository<TestResult,Integer> {
    TestResult getTestResultByTest_Sample_Account_Id(int id);
}
