package com.my.gradeMag.dao;

import com.my.gradeMag.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AdminMapper {

    @Select("select acot from admin where acot=#{acot} and password=#{password}")
    String queryAcotAndPsw(@Param("acot") String acot, @Param("password") String password);
}