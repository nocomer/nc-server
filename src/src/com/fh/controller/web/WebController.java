package com.fh.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.system.Menu;
import com.fh.entity.system.Role;
import com.fh.entity.system.User;
import com.fh.service.system.menu.MenuService;
import com.fh.service.system.role.RoleService;
import com.fh.service.system.user.UserService;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.PageData;
import com.fh.util.RightsHelper;
import com.fh.util.Tools;
import com.google.gson.Gson;

/*
 * 总入口
 */
@Controller
public class WebController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "menuService")
	private MenuService menuService;
	@Resource(name = "roleService")
	private RoleService roleService;

	@RequestMapping(value = "/web/test_json")
	@ResponseBody
	public String toTestJson() throws Exception {

		Test dog = new Test();
		dog.setName("You");
		dog.setAge("1");
		dog.setColor("red");

	
		return new Gson().toJson(dog).toString();

	}

	@RequestMapping(value = "/web/test_json2")
	public @ResponseBody Test toTestJson2() {

		Test dog = new Test();
		dog.setName("You");
		dog.setAge("1");
		dog.setColor("red");

		return dog;

	}

	@RequestMapping(value = "/web/test_map")
	@ResponseBody
	public Map<String, String> toTestMap() throws Exception {

		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value-1");
		map.put("key2", "value-2");
		return map;

	}

	public class Test {
		String Name;
		String Age;
		String Color;

		public void setName(String s) {
			this.Name = s;
		}

		public void setAge(String s) {
			this.Age = s;
		}

		public void setColor(String s) {
			this.Color = s;
		}

	}

}
