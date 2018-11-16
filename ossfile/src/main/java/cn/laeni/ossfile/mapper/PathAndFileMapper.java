package cn.laeni.ossfile.mapper;

import cn.laeni.ossfile.entity.PathAndFile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用于包装文件信息
 *
 * @author laeni.cn
 */
public interface PathAndFileMapper {

    /**
     * 查询该用户下所有文件(不包含文件夹)
     *
     * @param userId 用户Id
     * @return
     */
    @Select({
            "SELECT",
            "ps.path_id, ps.path_name, ps.parent_path_id, ps.time,",
            "ps.directory, fl.used, f.file_key, f.file_size, f.file_type",
            "FROM path_structure AS ps INNER JOIN file_link AS fl INNER JOIN files AS f",
            "ON ps.path_id = fl.path_id AND fl.`file_key` = f.`file_key`",
            "AND ps.user_id = #{userId,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    List<PathAndFile> selectAll(String userId);

    /**
     * 查询该用户指定路径下所有文件(不包含文件夹)
     *
     * @param userId 用户Id
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return
     */
    @Select({
            "SELECT",
            "ps.path_id, ps.path_name, ps.parent_path_id, ps.time,",
            "ps.directory, fl.used, f.file_key, f.file_size, f.file_type",
            "FROM path_structure AS ps INNER JOIN file_link AS fl INNER JOIN files AS f",
            "ON ps.path_id = fl.path_id AND fl.`file_key` = f.`file_key`",
            "AND ps.user_id = #{userId,jdbcType=CHAR}",

            "AND ps.`parent_path_id` = #{parentPathId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    List<PathAndFile> selectByUserIdAndPathId(@Param("userId") String userId, @Param("parentPathId")  Integer parentPathId);

    /**
     * 查询用户指定类型的全部文件
     * @param userId 用户Id
     * @param fileType 文件类型
     * @return
     */
    @Select({
            "SELECT",
            "ps.path_id, ps.path_name, ps.parent_path_id, ps.time,",
            "ps.directory, fl.used, f.file_key, f.file_size, f.file_type",
            "FROM path_structure AS ps INNER JOIN file_link AS fl INNER JOIN files AS f",
            "ON ps.path_id = fl.path_id AND fl.`file_key` = f.`file_key`",
            "AND ps.user_id = #{userId,jdbcType=CHAR}",
            "AND f.`file_type`  on (${fileType})"
    })
    @ResultMap("BaseResultMap")
    List<Object> selectByType(@Param("userId")String userId, @Param("fileType") String fileType);
}
