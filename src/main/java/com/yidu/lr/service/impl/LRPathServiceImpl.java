package com.yidu.lr.service.impl;

import com.yidu.entity.Path;
import com.yidu.lr.dao.LRPathDao;
import com.yidu.lr.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Path)表服务实现类
 *
 * @author makejava
 * @since 2021-01-01 14:54:48
 */
@Service
public class LRPathServiceImpl implements PathService {
    @Autowired
    private LRPathDao pathDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pathid 主键
     * @return 实例对象
     */
    @Override
    public Path queryById(Integer pathid) {
        return this.pathDao.queryById(pathid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Path> queryAllByLimit(int offset, int limit) {
        return this.pathDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    @Override
    public Path insert(Path path) {
        this.pathDao.insert(path);
        return path;
    }

    /**
     * 修改数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    @Override
    public Path update(Path path) {
        this.pathDao.update(path);
        return this.queryById(path.getPathid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pathid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pathid) {
        return this.pathDao.deleteById(pathid) > 0;
    }

    @Override
    public List<Path> queryAll(Path path) {
        return pathDao.queryAll(path);
    }

    @Override
    public Path queryByPathId(Integer pathid) {
        return pathDao.queryByPathId(pathid);
    }

    @Override
    public List<Path> queryByAll(Path path) {
        return pathDao.queryAll(path);
    }

    @Override
    public List<Map<String, Object>> queryByStartEnd() {
        return pathDao.queryByStartEnd();
    }
}