package tn.esprit.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entitys.Account;
import tn.esprit.Entitys.Roles;
import tn.esprit.Entitys.stateRegion;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {



    @Query("select ac from  Account ac JOIN  ac.user u   where  ((u.roles = :role)) ")
    List<Account> findAccountsByRole(@Param("role") Roles role   );
    @Query("select count (ac) from  Account ac JOIN  ac.user u   where  ((u.roles = :role)) ")
    Long countAccountsByRole(@Param("role") Roles role   );

    @Query("select count (ac) from  Account ac JOIN  ac.user u   where  ((u.roles = :role)and(ac.state = :state)) ")
    Long countAccountsByRoleAndState(@Param("role") stateRegion state , @Param("role") Roles role   );

    @Query("select count (ac) from  Account ac JOIN  ac.user u   where ((u.roles = tn.esprit.Entitys.Roles.Patient)and(ac.firstname = :firstname)) ")
    Long countPatientsByFirstname(@Param("firstname") String firstname    );
    @Query("select ac from  Account ac JOIN  ac.user u   where ((u.roles = tn.esprit.Entitys.Roles.Patient)and(ac.firstname = :firstname)) ")
    List<Account> ListPatientsByFirstname(@Param("firstname") String firstname    );


    @Query("select ac from  Account ac JOIN  ac.user u   where ((u.roles <> tn.esprit.Entitys.Roles.Patient)) ")
    List<Account> ListEmployeurs();
    @Query("select count (ac) from  Account ac JOIN  ac.user u   where ((u.roles <> tn.esprit.Entitys.Roles.Patient) and (u.roles <> tn.esprit.Entitys.Roles.Intern)  ) ")
    Long countEmployeurs();

}
