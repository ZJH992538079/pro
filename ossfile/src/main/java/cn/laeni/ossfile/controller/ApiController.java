package cn.laeni.ossfile.controller;

import cn.laeni.ossfile.entity.PathStructure;
import cn.laeni.ossfile.entity.constant.SystemCode;
import cn.laeni.ossfile.entity.other.ApiJson;
import cn.laeni.ossfile.service.PathAndFileService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 这里所有的Controller均通过js进行调用, 返回数据格式为Json格式
 * @author laeni.cn
 */
@RestController
public class ApiController {

    @Autowired
    PathAndFileService pathAndFileService;

    /**
     * 通过"用户ID"查询指定路径下的全部文件和目录
     * 即查询id为"userId"的用户中,"pathId"对应的目录下所有文件和目录
     * @param userId 用户ID
     * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
     * @return 包含数据的json对象
     */
    @RequestMapping("/getPathStructureList")
    public ApiJson getPathStructureList(String userId, Integer parentPathId){

        // 创建返回的JSON对象
        ApiJson<SystemCode> apiJson = new ApiJson<>(SystemCode.SUCCESS);
        // 设置返回的数据
        apiJson.setData(pathAndFileService.getAllTheFileFolder(userId, parentPathId));

        return apiJson;
    }
    
    public ApiJson<SystemCode> getFileByType(String userId, String typeName) {
    	
    	//创建返回的JSON对象
    	ApiJson<SystemCode> apiJson = new ApiJson<>(SystemCode.SUCCESS);
    	//设置返回的数据
    	 apiJson.setData(pathAndFileService.getAllTheFileFolder(userId, typeName));
    	
    	 return apiJson;
    }

    /**
     * 上传文件,上传成功后返回该文件的相关信息(其中包括网络URL)
     * @param upFile
     * @param userId
     * @return
     */
    public ApiJson upFile(MultipartFile upFile, String userId){
        // TODO
        // 接受到上传的文件后判断该文件是否已经在之前被上传过(可通过md5值和文件大小等判断),如果是新文件则正常上传,否则返回之前文件的信息
        return null;
    }

    /**
     * 删除文件
     * @param pathId 在后台唯一和一个用户的文件或目录对应的值,用户不会直接接触该值
     * @param force 是否为强制注册(不为空表示强制删除)
     */
    public void delFile(String pathId, String force) {
        // TODO
        // 删除文件时,先判断是否进行强制删除
        // 如果是则不去判断该文件是否被其他模块引用
        // 如果不是则先判断该文件是否有其他模块引用,如果有则返回被引用的提示信息

        // 这里的删除分为两步,第一步是删除用户的文件,
        // 第二部是删除真正的文件,如果一个文件被多个用户共享,则其中一个用户删除自己的文件不会影响其他用户的使用
    }

    /**
     * 提供一个接口供其他模块声明某个文件在什么地方被引用了多少次
     * 即表示地址为fileUrl的文件被ObjType引用了s次
     * @param fileUrl 文件的网络地址
     * @param ObjType 该文件的使用者
     * @param s 被引用的次数
     */
    public void setFileLink(String fileUrl, String ObjType, Integer s){
        // TODO
        // 首先对fileUrl进行拆分,把key和主机名提取出来(https://xx.xxx.com/xx1/xx2.jpg 中,key为"xx1/xx2.jpg",主机名为"xx.xxx.com")
        // 通过主机名判断和key判断该文件是否在系统中真实存在,如果存在则继续下面的操作
    }

    // 重命名指定文件或目录名
    public void reName(){

    }

    // 移动指定文件或目录到其他文件或目录中(逻辑复杂,暂不实现)
    // 复制(逻辑复杂,暂不实现)
}
