package com.sunnie.service;


import com.sunnie.pojo.TbPanel;
import com.sunnie.pojo.common.ZTreeNode;

import java.util.List;

/**
 * @author Sunnie
 */
public interface PanelService {

    /**
     * 通过id获取板块
     * @param id
     * @return
     */
    TbPanel getTbPanelById(int id);

    /**
     * 获取板块类目
     * @param position
     * @param showAll
     * @return
     */
    List<ZTreeNode> getPanelList(int position, boolean showAll);

    /**
     * 添加板块
     * @param tbPanel
     * @return
     */
    int addPanel(TbPanel tbPanel);

    /**
     * 更新板块
     * @param tbPanel
     * @return
     */
    int updatePanel(TbPanel tbPanel);

    /**
     * 删除板块
     * @param id
     * @return
     */
    int deletePanel(int id);
}
