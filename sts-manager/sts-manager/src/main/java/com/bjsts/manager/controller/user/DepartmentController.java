package com.bjsts.manager.controller.user;

import com.bjsts.manager.core.constants.GlobalConstants;
import com.bjsts.manager.core.controller.AbstractController;
import com.bjsts.manager.entity.user.DepartmentEntity;
import com.bjsts.manager.form.user.DepartmentForm;
import com.bjsts.manager.query.user.UserSearchable;
import com.bjsts.manager.service.user.DepartmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

/**
 * @author jinsheng
 * @since 2016-04-26 16:56
 */
@Controller
@RequestMapping("/department")
@SessionAttributes("departmentSearchable")
public class DepartmentController extends AbstractController {

    @Autowired
    private DepartmentService departmentService;

    @RequiresPermissions("arsenal:department:list")
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(UserSearchable departmentSearchable, @PageableDefault(size = GlobalConstants.DEFAULT_PAGE_SIZE, sort = "createdTime", direction = Sort.Direction.DESC) Pageable pageable, ModelMap modelMap) {
        List<DepartmentEntity> departmentEntityList = departmentService.findAll();
        modelMap.addAttribute("list", departmentEntityList);
        return "department/list";
    }

    @RequiresPermissions("arsenal:department:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute DepartmentForm departmentForm, ModelMap modelMap) {
        if (modelMap.containsKey(BINDING_RESULT_KEY)) {
            modelMap.addAttribute(BindingResult.class.getName().concat(".departmentForm"), modelMap.get(BINDING_RESULT_KEY));
        }
        if (Objects.isNull(departmentForm.getDepartment())) {
            departmentForm.setDepartment(new DepartmentEntity());
        }
        modelMap.put("action", "create");
        return "department/edit";
    }

    @RequiresPermissions("arsenal:department:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(DepartmentForm departmentForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(departmentForm);
            return "redirect:/department/create";
        }
        DepartmentEntity departmentEntity = departmentForm.getDepartment();
        departmentService.save(departmentEntity);
        return "result";
    }

    @RequiresPermissions("arsenal:department:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id, @ModelAttribute DepartmentForm departmentForm, RedirectAttributes redirectAttributes, ModelMap modelMap) {
        if (modelMap.containsKey(BINDING_RESULT_KEY)) {
            modelMap.addAttribute(BindingResult.class.getName().concat(".departmentForm"), modelMap.get(BINDING_RESULT_KEY));
        }
        DepartmentEntity departmentEntity = departmentService.get(id);
        if (Objects.isNull(departmentEntity)) {
            logger.error("修改部门,未查询[id={}]的部门信息", id);
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE_KEY, "无效数据!");
            return "redirect:/error";
        }
        departmentForm.setDepartment(departmentEntity);
        modelMap.put("action", "update");
        return "department/edit";
    }

    @RequiresPermissions("arsenal:department:update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(DepartmentForm departmentForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(departmentForm);
            return "redirect:/department/update/" + departmentForm.getDepartment().getId();
        }
        DepartmentEntity department = departmentForm.getDepartment();
        DepartmentEntity departmentEntity = departmentService.get(department.getId());
        departmentEntity.setName(department.getName());
        departmentService.update(departmentEntity);
        return "result";
    }

    @RequiresPermissions("arsenal:department:view")
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("department", departmentService.get(id));
        return "department/view";
    }
}
