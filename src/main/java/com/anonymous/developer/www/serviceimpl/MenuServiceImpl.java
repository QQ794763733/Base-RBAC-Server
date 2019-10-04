package com.anonymous.developer.www.serviceimpl;

import com.anonymous.developer.www.mapper.MenuMapper;
import com.anonymous.developer.www.model.Menu;
import com.anonymous.developer.www.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description:
 * @Datetime: 2019/9/23 5:26 下午
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getAll() {
        List<Menu> menus = generateMenuTree(menuMapper.selectAll(), 0);
        return menus;
    }

    /**
     * 生成菜单树算法
     * @param menus
     * @param parentId
     */
    private List<Menu> generateMenuTree(List<Menu> menus,Integer parentId){
        List<Menu> tree = new ArrayList<>();
        for(int i = 0; i < menus.size(); i++){
            if(menus.get(i).getMenuParentId().equals(parentId)){
                menus.get(i).setSubMenus(generateMenuTree(menus,menus.get(i).getMenuId()));
                tree.add(menus.get(i));
            }
        }
        if(tree.size() == 0){
            return null;
        }
        return tree;
    }
}