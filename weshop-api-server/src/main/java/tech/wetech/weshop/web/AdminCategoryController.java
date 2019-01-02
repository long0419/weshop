package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.CategoryService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController extends BaseController<Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Result<PageInfoVO<Category>> queryPageInfo(Category entity, PageQuery pageQuery) {
        Result<PageInfoVO<Category>> result = super.queryPageInfo(entity, pageQuery);
        Map<String, Object> extra = new HashMap(16) {{
            put("categoryLevel", Arrays.stream(CategoryLevelEnum.values()).collect(Collectors.toMap(c -> c, CategoryLevelEnum::getName)));
            put("l1", categoryService.queryCategoryByLevel(CategoryLevelEnum.L1));
        }};
        result.getData().setExtra(extra);
        return result;
    }
}
