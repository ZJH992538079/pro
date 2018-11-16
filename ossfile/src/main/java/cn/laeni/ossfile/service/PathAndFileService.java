package cn.laeni.ossfile.service;

import cn.laeni.ossfile.entity.PathAndFile;
import cn.laeni.ossfile.entity.PathStructure;

import java.util.List;

/**
 *
 * @author laeni.cn
 */
public interface PathAndFileService {

    /**
     * 通过"用户ID"查询指定路径下的全部目录
     * @param userId 用户Id
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return
     */
    List<PathStructure> getPathStructureList(String userId, Integer parentPathId);

    /**
     * 获取用户指定目录下的全部文件
     * @param userId 用户Id
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return
     */
    List<PathAndFile> getPathAndFile(String userId, Integer parentPathId);

    /**
     * 获取所有文件和目录
     * @param userId 用户Id
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return
     */
    List<Object> getAllTheFileFolder(String userId, Integer parentPathId);
    
    /**
     * 按类型获取文件
     * @param userId 用户Id
     * @param typeName 该文件的类型名字
     * @return
     */
    List<Object> getAllTheFileFolder(String userId, String type);
}
