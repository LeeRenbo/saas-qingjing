package com.lrb.saas.shop.controller.order;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrb.saas.core.annotation.SAASInterface;
import com.lrb.saas.core.message.request.SAASRequest;
import com.lrb.saas.core.message.request.query.SAASQueryRequest;
import com.lrb.saas.core.message.response.SAASQueryResponse;
import com.lrb.saas.core.message.response.SAASResponse;
import com.lrb.saas.core.model.qingjing.order.Address;
import com.lrb.saas.core.validation.group.DELETE;
import com.lrb.saas.core.validation.group.PATCH;
import com.lrb.saas.core.validation.group.POST;
import com.lrb.saas.core.validation.group.PUT;
import com.lrb.saas.framework.controller.BaseController;

@RestController
@RequestMapping("address")
public class AddressController extends BaseController<Address> {

	@Override
	@GetMapping
	@SAASInterface(name = "获取", remark = "?id=主键 传值")
	public SAASResponse<Address> get(String id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping
	@SAASInterface(name = "增加")
	public SAASResponse post(@Validated(POST.class) @RequestBody SAASRequest<Address> request,
			BindingResult bindingResult) throws Exception {
		return super.post(request, bindingResult);
	}

	@Override
	@PutMapping
	@SAASInterface(name = "完全修改")
	public SAASResponse put(@Validated(PUT.class) @RequestBody SAASRequest<Address> request,
			BindingResult bindingResult) throws Exception {
		return super.put(request, bindingResult);
	}

	@Override
	@PatchMapping
	@SAASInterface(name = "部分修改")
	public SAASResponse patch(@Validated(PATCH.class) @RequestBody SAASRequest<Address> request,
			BindingResult bindingResult) throws Exception {
		return super.patch(request, bindingResult);
	}

	@Override
	@DeleteMapping(consumes = "application/json")
	@SAASInterface(name = "删除")
	public SAASResponse delete(@Validated(DELETE.class) @RequestBody SAASRequest<Address> request,
			BindingResult bindingResult) throws Exception {
		return super.delete(request, bindingResult);
	}

	@Override
	@RequestMapping(value = "/query")
	public SAASQueryResponse<Address> query(@RequestBody SAASRequest<SAASQueryRequest> request) throws Exception {
		return super.query(request);
	}

	@Override
	@DeleteMapping
	@SAASInterface(remark = "批量删除")
	public SAASResponse deleteAll(String[] ids) throws Exception {
		return super.deleteAll(ids);
	}
}
