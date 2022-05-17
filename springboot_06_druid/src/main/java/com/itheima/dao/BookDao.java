package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
