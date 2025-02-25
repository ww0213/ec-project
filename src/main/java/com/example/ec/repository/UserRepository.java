package com.example.ec.repository;

import com.example.ec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 透過 username 查找用戶
    Optional<User> findByUsername(String username);

    // 透過 email 查找用戶
    Optional<User> findByEmail(String email);

    // 透過 username 或 email 查找用戶
    Optional<User> findByUsernameOrEmail(String username, String email);

    // 查找所有某個電話號碼的用戶
    List<User> findByTel(String tel);

    // 查找所有密碼為空的用戶
    List<User> findByPasswordIsNull();

    // 查找所有 email 不是 null 的用戶
    List<User> findByEmailIsNotNull();

    // 查找某個日期後註冊的用戶
    List<User> findByCreateTimeAfter(java.util.Date createTime);

    // 查找某個日期前註冊的用戶
    List<User> findByCreateTimeBefore(java.util.Date createTime);

    // 查找某個時間範圍內註冊的用戶
    List<User> findByCreateTimeBetween(java.util.Date startDate, java.util.Date endDate);

    // 查找 username 包含特定字串的用戶（類似 SQL 的 LIKE）
    List<User> findByUsernameContaining(String keyword);

    // 查找 username 以特定字串開頭的用戶
    List<User> findByUsernameStartingWith(String prefix);

    // 查找 username 以特定字串結尾的用戶
    List<User> findByUsernameEndingWith(String suffix);

    // 自訂 JPQL 查詢：透過 username 更新 email
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = ?2 WHERE u.username = ?1")
    int updateEmailByUsername(String username, String email);

    // 自訂 JPQL 刪除：刪除特定 username 的用戶
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.username = ?1")
    void deleteByUsername(String username);

    // 查找總用戶數
    @Query("SELECT COUNT(u) FROM User u")
    long countTotalUsers();

    // 查找所有用戶，依 createTime 倒序排序
    List<User> findAllByOrderByCreateTimeDesc();
}