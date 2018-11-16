package cn.laeni.ossfile.service.impl;

import cn.laeni.ossfile.entity.PathAndFile;
import cn.laeni.ossfile.entity.PathStructure;
import cn.laeni.ossfile.mapper.PathAndFileMapper;
import cn.laeni.ossfile.mapper.PathStructureMapper;
import cn.laeni.ossfile.service.PathAndFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laeni.cn
 */
@Service
public class PathAndFileServiceIml implements PathAndFileService {

	@Autowired
	PathStructureMapper pathStructureMapper;
	@Autowired
	PathAndFileMapper pathAndFileMapper;

	/**
	 * 通过"用户ID"查询指定路径下的全部目录
	 * 
	 * @param userId       用户Id
	 * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
	 * @return
	 */
	@Override
	public List<PathStructure> getPathStructureList(String userId, Integer parentPathId) {
		return pathStructureMapper.selectByUserId(userId, parentPathId);
	}

	/**
	 * 获取用户指定目录下的全部文件
	 * 
	 * @param userId       用户Id
	 * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
	 * @return
	 */
	@Override
	public List<PathAndFile> getPathAndFile(String userId, Integer parentPathId) {
		return pathAndFileMapper.selectByUserIdAndPathId(userId, parentPathId);
	}

	/**
	 * 获取所有文件和目录
	 * 
	 * @param userId       用户Id
	 * @param parentPathId 该文件或文件夹的父路径id(根路径的父路径ID为null)
	 * @return
	 */
	@Override
	public List<Object> getAllTheFileFolder(String userId, Integer parentPathId) {
		ArrayList<Object> list = new ArrayList<>();
		// 查询所有文件夹
		list.addAll(this.getPathStructureList(userId, parentPathId));
		// 查询所有文件
		list.addAll(this.getPathAndFile(userId, parentPathId));

		return list;
	}

	/**
	 * 按类型获取文件
	 * 
	 * @param userId   用户Id
	 * @param typeName 该文件的类型名字
	 * @return
	 */
	@Override
	public List<Object> getAllTheFileFolder(String userId, String typeName) {
		String type = null;
		switch (typeName) {
		case "图片":
			type = "'jpg','png','tif','gif','svg','psd'";
			break;
		case "音乐":
			type = "'MP3','WMA','FLAC','AAC','MMF','AMR','M4A','M4R','OGG'";
			break;
		case "视频":
			type = "'AVI','WMV','MP4','MKV','AMV'";
			break;
		case "文本":
			type = "'txt','doc','docx','wps','ppt'";
			break;
		default:
			return null;
		}
		return pathAndFileMapper.selectByType(userId, type);
	}
}
