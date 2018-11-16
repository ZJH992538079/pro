package cn.laeni.ossfile.entity;

public class PathStructure {
    private Integer pathId;

    private String userId;

    private String pathName;

    private Integer parentPathId;

    private Integer time;

    private Boolean directory;

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Integer getParentPathId() {
        return parentPathId;
    }

    public void setParentPathId(Integer parentPathId) {
        this.parentPathId = parentPathId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getDirectory() {
        return directory;
    }

    public void setDirectory(Boolean directory) {
        this.directory = directory;
    }
}