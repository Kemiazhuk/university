package com.kem.university.service;

import com.kem.university.config.Role;
import com.kem.university.dto.Account;
import com.kem.university.dto.Profile;
import com.kem.university.entity.AccountEntity;
import com.kem.university.entity.StudentEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.AccountRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService implements UserDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final StudentService studentService;
//    private final TeacherService teacherService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountService(AccountRepository accountRepository,
                          StudentService studentService,
//                          TeacherService teacherService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.studentService = studentService;
//        this.teacherService = teacherService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public TeacherEntity getTeacherEntityByUserName (String userName){
        Optional<AccountEntity> accountEntity = accountRepository.findByUserName(userName);
        return accountEntity.map(AccountEntity::getTeacherEntity).orElse(null);
    }

    public Profile getInformationAboutAccount(String userName) {
        LOGGER.debug("Get information about account from DB by user name");
        Optional<AccountEntity> accountEntity = accountRepository.findByUserName(userName);
        return accountEntity
                .map(this::convertDataToProfile)
                .orElse(null);
    }

    public void updateDataStudentToAccount(Profile profile, String userName) {
        LOGGER.debug("Update student account in DB");
        Optional<AccountEntity> accountEntity = accountRepository.findByUserName(userName);
        if (accountEntity.isPresent()) {
            if (!profile.getPassword().isEmpty()) {
                accountEntity.get().setUserPassword(profile.getPassword());
            }
            if (!profile.getFirstName().isEmpty()) {
                accountEntity.get().getStudentEntity().setFirstName(profile.getFirstName());
            }
            if (!profile.getSecondName().isEmpty()) {
                accountEntity.get().getStudentEntity().setSecondName(profile.getSecondName());
            }
            if (!profile.getEmail().isEmpty()) {
                accountEntity.get().getStudentEntity().setEmail(profile.getEmail());
            }
            accountRepository.save(accountEntity.get());
        }
    }

    public void updateDataTeacherToAccount(Profile profile, String userName) {
        LOGGER.debug("Update teacher account in DB");
        Optional<AccountEntity> accountEntity = accountRepository.findByUserName(userName);
        if (accountEntity.isPresent()) {
            if (!profile.getPassword().isEmpty()) {
                accountEntity.get().setUserPassword(profile.getPassword());
            }
            if (!profile.getFirstName().isEmpty()) {
                accountEntity.get().getTeacherEntity().setFirstName(profile.getFirstName());
            }
            if (!profile.getSecondName().isEmpty()) {
                accountEntity.get().getTeacherEntity().setSecondName(profile.getSecondName());
            }
            if (!profile.getEmail().isEmpty()) {
                accountEntity.get().getTeacherEntity().setEmail(profile.getEmail());
            }
            accountRepository.save(accountEntity.get());
        }
    }

//    public Account convertDataToAccount(AccountEntity accountEntity) {
//        LOGGER.debug("Convert data to DTO Account");
//        return new Account()
//                .newBuilder()
//                .setId(accountEntity.getId())
//                .setLogin(accountEntity.getUserName())
//                .setPassword(accountEntity.getUserPassword())
//                .setRole(Role.valueOf(accountEntity.getRole()))
//                .setStudent(studentService.convertDataToStudent(accountEntity.getStudentEntity()))
//                .setTeacher(teacherService.convertDataToTeacher(accountEntity.getTeacherEntity()))
//                .build();
//    }

    public Profile convertDataToProfile(AccountEntity accountEntity) {
        LOGGER.debug("Convert data to DTO Account");
        return new Profile()
                .newBuilder()
                .setLogin(accountEntity.getUserName())
                .setPassword(accountEntity.getUserPassword())
                .setFirstName(accountEntity.getStudentEntity() != null
                        ? accountEntity.getStudentEntity().getFirstName()
                        :accountEntity.getTeacherEntity().getFirstName())
                .setSecondName(accountEntity.getStudentEntity() != null
                        ? accountEntity.getStudentEntity().getSecondName()
                        :accountEntity.getTeacherEntity().getSecondName())
                .setEmail(accountEntity.getStudentEntity() != null
                        ? accountEntity.getStudentEntity().getEmail()
                        :accountEntity.getTeacherEntity().getEmail())
                .setRole(accountEntity.getRole())
                .build();
    }

    public AccountEntity createAccount(Profile profile,
                                       StudentEntity studentEntity,
                                       TeacherEntity teacherEntity) {
        if (accountRepository.findByUserName(profile.getLogin()).isEmpty()) {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setId(UUID.randomUUID().toString());
            accountEntity.setUserName(profile.getLogin());
            accountEntity.setUserPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
            accountEntity.setRole(profile.getRole());
            accountEntity.setStudentEntity(studentEntity);
            accountEntity.setTeacherEntity(teacherEntity);
            String id = accountEntity.getId();
            accountRepository.save(accountEntity);
           Optional<AccountEntity> a =  accountRepository.findById(id);
            return accountEntity;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountEntity> accountEntity = accountRepository.findByUserName(username);
        if (accountEntity.isPresent()) {
            User user = new User(accountEntity.get().getUserName(),
                    accountEntity.get().getUserPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_" + accountEntity.get().getRole())));
            return user;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
