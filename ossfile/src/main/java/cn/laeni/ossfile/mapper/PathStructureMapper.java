package cn.laeni.ossfile.mapper;

import cn.laeni.ossfile.entity.PathStructure;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PathStructureMapper {
    @Delete({
        "delete from path_structure",
        "where path_id = #{pathId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pathId);

    @Insert({
        "insert into path_structure (path_id, user_id, ",
        "path_name, parent_path_id, ",
        "time, `directory`)",
        "values (#{pathId,jdbcType=INTEGER}, #{userId,jdbcType=CHAR}, ",
        "#{pathName,jdbcType=CHAR}, #{parentPathId,jdbcType=INTEGER}, ",
        "#{time,jdbcType=INTEGER}, #{`directory`,jdbcType=BIT})"
    })
    int insert(PathStructure record);

    int insertSelective(PathStructure record);

    int updateByPrimaryKeySelective(PathStructure record);

    @Update({
        "update path_structure",
        "set user_id = #{userId,jdbcType=CHAR},",
          "path_name = #{pathName,jdbcType=CHAR},",
          "parent_path_id = #{parentPathId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=INTEGER},",
          "`directory` = #{directory,jdbcType=BIT}",
        "where path_id = #{pathId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PathStructure record);

    /**
     * 根据主键查询一条记录
     * @param pathId
     * @return
     */
    @Select({
            "select",
            "path_id, user_id, path_name, parent_path_id, time, `directory`",
            "from path_structure",
            "where path_id = #{pathId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    PathStructure selectByPrimaryKey(Integer pathId);

    /**
     * 查询该用户指定路径下的所有文件夹(根路径的父路径ID为null)
     * @param userId 用户Id
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return
     */
    @Select({
            "select",
            "path_id, user_id, path_name, parent_path_id, time, `directory`",
            "from path_structure",
            "where",
            "user_id = #{userId,jdbcType=CHAR}",
            "AND",
            "parent_path_id = #{parentPathId,jdbcType=INTEGER}",
            /* 只获取文件夹 */
            "AND directory = 1"
    })
    @ResultMap("BaseResultMap")
    List<PathStructure> selectByUserId(@Param("userId") String userId, @Param("parentPathId") Integer parentPathId);
}