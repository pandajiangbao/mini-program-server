package com.panda.animeStore.controller;

import com.panda.animeStore.entity.Panda;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.util.ResultJson;
import com.panda.animeStore.service.PandaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panda
 * @date 2018-12-02 13:31
 */
@Slf4j
@RestController
public class PandaController {
	@Autowired
	private PandaService pandaService;

	@GetMapping("/pandas")
	public ResultJson getPandaList() {
		throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
//		List<Panda> pandaList = pandaService.getPandaList();
//		pandaList.forEach(panda -> System.out.println("panda = " + panda));
//		return ResultJson.responseResult(pandaList);
	}

	@GetMapping("/pandas/{id}")
	public ResultJson getPandaById(@PathVariable Integer id) {
		Panda panda = pandaService.getPandaById(id);
		return ResultJson.result(panda);
	}

}
